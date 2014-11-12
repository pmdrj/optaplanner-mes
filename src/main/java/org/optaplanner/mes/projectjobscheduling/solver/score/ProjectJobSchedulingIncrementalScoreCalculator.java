package org.optaplanner.mes.projectjobscheduling.solver.score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.bendable.BendableScore;
import org.optaplanner.core.impl.score.director.incremental.AbstractIncrementalScoreCalculator;
import org.optaplanner.mes.projectjobscheduling.domain.Allocation;
import org.optaplanner.mes.projectjobscheduling.domain.ExecutionMode;
import org.optaplanner.mes.projectjobscheduling.domain.JobType;
import org.optaplanner.mes.projectjobscheduling.domain.Project;
import org.optaplanner.mes.projectjobscheduling.domain.ResourceRequirement;
import org.optaplanner.mes.projectjobscheduling.domain.Schedule;
import org.optaplanner.mes.projectjobscheduling.domain.ScoreDef;
import org.optaplanner.mes.projectjobscheduling.domain.ScoreDefCode;
import org.optaplanner.mes.projectjobscheduling.domain.resource.Resource;
import org.optaplanner.mes.projectjobscheduling.solver.score.capacity.NonrenewableResourceCapacityTracker;
import org.optaplanner.mes.projectjobscheduling.solver.score.capacity.RenewableResourceCapacityTracker;
import org.optaplanner.mes.projectjobscheduling.solver.score.capacity.ResourceCapacityTracker;
import org.optaplanner.mes.projectjobscheduling.solver.score.resourcegap.ResourceGapTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectJobSchedulingIncrementalScoreCalculator extends AbstractIncrementalScoreCalculator<Schedule> {

	private Map<Resource, ResourceCapacityTracker> resourceCapacityTrackerMap;
	private Map<Resource, ResourceGapTracker> resourceGapTrackerMap;
	private Map<Project, Integer> projectEndDateMap;
	private int maximumProjectEndDate;
	private Map<ScoreDefCode, ScoreDef> scoreDefMap;
	private ScoreDef[] hardScoreDefArray;
	private ScoreDef[] softScoreDefArray;

	protected final transient Logger logger = LoggerFactory.getLogger(getClass());

	public void resetWorkingSolution(Schedule schedule) {
		this.scoreDefMap = schedule.getScoreDefMap();
		this.hardScoreDefArray = schedule.getHardScoreDefArray();
		this.softScoreDefArray = schedule.getSoftScoreDefArray();
		List<Resource> resourceList = schedule.getResourceList();
		resourceCapacityTrackerMap = new HashMap<Resource, ResourceCapacityTracker>(resourceList.size());
		resourceGapTrackerMap = new HashMap<Resource, ResourceGapTracker>(resourceList.size());
		for (Resource resource : resourceList) {
			resourceCapacityTrackerMap.put(resource, resource.isRenewable() ? new RenewableResourceCapacityTracker(
					resource) : new NonrenewableResourceCapacityTracker(resource));
			resourceGapTrackerMap.put(resource, new ResourceGapTracker(resource));
			resource.getAllocationList().clear();
		}
		List<Project> projectList = schedule.getProjectList();
		projectEndDateMap = new HashMap<Project, Integer>(projectList.size());
		maximumProjectEndDate = 0;
		int minimumReleaseDate = Integer.MAX_VALUE;
		for (Project p : projectList) {
			minimumReleaseDate = Math.min(p.getReleaseDate(), minimumReleaseDate);
		}

		for (ScoreDefCode code : scoreDefMap.keySet()) {
			scoreDefMap.get(code).setValue(0);
		}

		if (scoreDefMap.containsKey(ScoreDefCode.SPAN)) {
			scoreDefMap.get(ScoreDefCode.SPAN).add(minimumReleaseDate);
		}

		for (Allocation allocation : schedule.getAllocationList()) {
			insert(allocation);
		}

		if (scoreDefMap.containsKey(ScoreDefCode.GAP)) {
			for (Resource resource : resourceList) {
				ResourceGapTracker gapTracker = resourceGapTrackerMap.get(resource);
				scoreDefMap.get(ScoreDefCode.GAP).subtruct(gapTracker.getGap());
				logger.trace("Allocation list on resource {}: {}", resource.toString(),
						getAllocationListOnResource(resource));
				logger.trace("Sum gap on mesMachineNr {}: {}", resource.getMesMachineNr(), gapTracker.getGap());
			}
		}

		if (scoreDefMap.containsKey(ScoreDefCode.DELAY)) {
			for (Allocation allocation : schedule.getAllocationList()) {
				if (allocation.getJob().getJobType() == JobType.STANDARD) {
					scoreDefMap.get(ScoreDefCode.DELAY).subtruct(allocation.getDelay());
				}
			}
		}
	}

	public void beforeEntityAdded(Object entity) {
		// Do nothing
	}

	public void afterEntityAdded(Object entity) {
		Allocation allocation = (Allocation) entity;
		logger.trace("ScoreCalculator, afterEntityAdded: insert allocation");
		logger.trace("    allocation  : {}", allocation.toString());
		insert(allocation);
	}

	public void beforeVariableChanged(Object entity, String variableName) {
		Allocation allocation = (Allocation) entity;
		logger.trace("ScoreCalculator, beforeVariableChanged: retract allocation");
		logger.trace("    allocation  : {}", allocation.toString());
		logger.trace("    variableName: {}", variableName);
		retract(allocation);
	}

	public void afterVariableChanged(Object entity, String variableName) {
		Allocation allocation = (Allocation) entity;
		logger.trace("ScoreCalculator, afterVariableChanged: insert allocation");
		logger.trace("    allocation  : {}", allocation.toString());
		logger.trace("    variableName: {}", variableName);
		insert(allocation);
	}

	public void beforeEntityRemoved(Object entity) {
		Allocation allocation = (Allocation) entity;
		logger.trace("ScoreCalculator, beforeEntityRemoved: retract allocation");
		logger.trace("    allocation  : {}", allocation.toString());
		retract(allocation);
	}

	public void afterEntityRemoved(Object entity) {
		// Do nothing
	}

	private void insert(Allocation allocation) {
		// Job precedence is build-in
		// Resource capacity
		ExecutionMode executionMode = allocation.getExecutionMode();
		if (executionMode != null && allocation.getJob().getJobType() == JobType.STANDARD) {
			for (ResourceRequirement resourceRequirement : executionMode.getResourceRequirementList()) {
				Resource resource = resourceRequirement.getResource();

				if (scoreDefMap.containsKey(ScoreDefCode.RESOURCE)) {
					ResourceCapacityTracker tracker = resourceCapacityTrackerMap.get(resource);
					scoreDefMap.get(ScoreDefCode.RESOURCE).subtruct(tracker.getHardScore());
					tracker.insert(resourceRequirement, allocation);
					scoreDefMap.get(ScoreDefCode.RESOURCE).add(tracker.getHardScore());
				}

				if (scoreDefMap.containsKey(ScoreDefCode.GAP)) {
					ResourceGapTracker gapTracker = resourceGapTrackerMap.get(resource);
					scoreDefMap.get(ScoreDefCode.GAP).add(gapTracker.getGap());
					putAlocationOnResource(allocation, resource);
					scoreDefMap.get(ScoreDefCode.GAP).subtruct(gapTracker.getGap());
				}
			}
			if (scoreDefMap.containsKey(ScoreDefCode.DELAY)) {
				scoreDefMap.get(ScoreDefCode.DELAY).subtruct(allocation.getDelay());
			}
		}

		// Total project delay and total make span
		if (allocation.getJob().getJobType() == JobType.SINK) {
			Integer endDate = allocation.getEndDate();
			if (endDate != null) {
				Project project = allocation.getProject();
				projectEndDateMap.put(project, endDate);

				// Total project delay
				if (scoreDefMap.containsKey(ScoreDefCode.FREE_SPACE)) {
					scoreDefMap.get(ScoreDefCode.FREE_SPACE).subtruct(endDate - project.getCriticalPathEndDate());
				}

				// Total make span
				if (endDate > maximumProjectEndDate) {
					if (scoreDefMap.containsKey(ScoreDefCode.SPAN)) {
						scoreDefMap.get(ScoreDefCode.SPAN).subtruct(endDate - maximumProjectEndDate);
					}
					maximumProjectEndDate = endDate;
				}
			}
		}
	}

	private void retract(Allocation allocation) {
		// Job precedence is build-in
		// Resource capacity
		ExecutionMode executionMode = allocation.getExecutionMode();
		if (executionMode != null && allocation.getJob().getJobType() == JobType.STANDARD) {
			for (ResourceRequirement resourceRequirement : executionMode.getResourceRequirementList()) {
				Resource resource = resourceRequirement.getResource();

				if (scoreDefMap.containsKey(ScoreDefCode.RESOURCE)) {
					ResourceCapacityTracker tracker = resourceCapacityTrackerMap.get(resource);
					scoreDefMap.get(ScoreDefCode.RESOURCE).subtruct(tracker.getHardScore());
					tracker.retract(resourceRequirement, allocation);
					scoreDefMap.get(ScoreDefCode.RESOURCE).add(tracker.getHardScore());
				}

				if (scoreDefMap.containsKey(ScoreDefCode.GAP)) {
					ResourceGapTracker gapTracker = resourceGapTrackerMap.get(resource);
					scoreDefMap.get(ScoreDefCode.GAP).add(gapTracker.getGap());
					while (resource.getAllocationList().remove(allocation)) {
					}
					scoreDefMap.get(ScoreDefCode.GAP).subtruct(gapTracker.getGap());
				}
			}
		}		

		// Total project delay and total make span
		if (allocation.getJob().getJobType() == JobType.SINK) {
			Integer endDate = allocation.getEndDate();
			if (endDate != null) {
				Project project = allocation.getProject();
				projectEndDateMap.remove(project);

				// Total project delay
				if (scoreDefMap.containsKey(ScoreDefCode.FREE_SPACE)) {
					scoreDefMap.get(ScoreDefCode.FREE_SPACE).add(endDate - project.getCriticalPathEndDate());
				}

				// Total make span
				if (endDate == maximumProjectEndDate) {
					updateMaximumProjectEndDate();
					if (scoreDefMap.containsKey(ScoreDefCode.SPAN)) {
						scoreDefMap.get(ScoreDefCode.SPAN).add(endDate - maximumProjectEndDate);
					}
				}
			}
		}
	}

	private void updateMaximumProjectEndDate() {
		int maximum = 0;
		for (Integer endDate : projectEndDateMap.values()) {
			if (endDate > maximum) {
				maximum = endDate;
			}
		}
		maximumProjectEndDate = maximum;
	}

	public Score<?> calculateScore() {

		int[] hardScoreValueArray = new int[hardScoreDefArray.length];
		int[] softScoreValueArray = new int[softScoreDefArray.length];
		for (int i = 0; i != hardScoreDefArray.length; i++) {
			hardScoreValueArray[i] = hardScoreDefArray[i].getValue();
		}
		for (int i = 0; i != softScoreDefArray.length; i++) {
			softScoreValueArray[i] = softScoreDefArray[i].getValue();
		}
		return BendableScore.valueOf(hardScoreValueArray, softScoreValueArray);
	}

	private String getAllocationListOnResource(Resource resource) {
		String theList = "";
		List<Allocation> allocationList = new ArrayList<Allocation>(resource.getAllocationList());
		try {
			for (Allocation allocation : allocationList) {
				if (theList != "") {
					theList += ", ";
				}
				theList += allocation.toString();
			}
		} catch (Exception e) {
			theList = e.toString();
		}
		return theList;
	}

	private void putAlocationOnResource(Allocation allocation, Resource resource) {
		List<Resource> resourceList = allocation.getSchedule().getResourceList();
		for (Resource r : resourceList) {
			List<Allocation> allocationList = r.getAllocationList();
			while (allocationList.remove(allocation)) {
			}
		}
		resource.getAllocationList().add(allocation);
	}

}
