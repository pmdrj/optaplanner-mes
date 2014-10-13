package org.optaplanner.mes.projectjobscheduling.solver.score;

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
import org.optaplanner.mes.projectjobscheduling.domain.resource.Resource;
import org.optaplanner.mes.projectjobscheduling.solver.score.capacity.NonrenewableResourceCapacityTracker;
import org.optaplanner.mes.projectjobscheduling.solver.score.capacity.RenewableResourceCapacityTracker;
import org.optaplanner.mes.projectjobscheduling.solver.score.capacity.ResourceCapacityTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectJobSchedulingIncrementalScoreCalculator extends AbstractIncrementalScoreCalculator<Schedule> {

    private Map<Resource, ResourceCapacityTracker> resourceCapacityTrackerMap;
    private Map<Project, Integer> projectEndDateMap;
    private int maximumProjectEndDate;

    private int hardScore;
    private int soft0Score;
    private int soft1Score;
    
    protected final transient Logger logger = LoggerFactory.getLogger(getClass());
    

    public void resetWorkingSolution(Schedule schedule) {
        List<Resource> resourceList = schedule.getResourceList();
        resourceCapacityTrackerMap = new HashMap<Resource, ResourceCapacityTracker>(resourceList.size());
        for (Resource resource : resourceList) {
            resourceCapacityTrackerMap.put(resource, resource.isRenewable()
                    ? new RenewableResourceCapacityTracker(resource)
                    : new NonrenewableResourceCapacityTracker(resource));
        }
        List<Project> projectList = schedule.getProjectList();
        projectEndDateMap = new HashMap<Project, Integer>(projectList.size());
        maximumProjectEndDate = 0;
        hardScore = 0;
        soft0Score = 0;
        soft1Score = 0;
        int minimumReleaseDate = Integer.MAX_VALUE;
        for (Project p: projectList) {
            minimumReleaseDate = Math.min(p.getReleaseDate(), minimumReleaseDate);
        }
        soft1Score += minimumReleaseDate;
        for (Allocation allocation : schedule.getAllocationList()) {
            insert(allocation);
        }
    }

    public void beforeEntityAdded(Object entity) {
        // Do nothing
    }

    public void afterEntityAdded(Object entity) {
        insert((Allocation) entity);
    }

    public void beforeVariableChanged(Object entity, String variableName) {
        retract((Allocation) entity);
    }

    public void afterVariableChanged(Object entity, String variableName) {
        insert((Allocation) entity);
    }

    public void beforeEntityRemoved(Object entity) {
        retract((Allocation) entity);
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
                ResourceCapacityTracker tracker = resourceCapacityTrackerMap.get(
                        resourceRequirement.getResource());
                hardScore -= tracker.getHardScore();
                tracker.insert(resourceRequirement, allocation);
                hardScore += tracker.getHardScore();
            }            
        }
        // Total project delay and total make span
        if (allocation.getJob().getJobType() == JobType.SINK) {
            Integer endDate = allocation.getEndDate();
            if (endDate != null) {
                Project project = allocation.getProject();
                projectEndDateMap.put(project, endDate);
                // Total project delay
                soft0Score -= endDate - project.getCriticalPathEndDate();
                // Total make span
                if (endDate > maximumProjectEndDate) {
                    soft1Score -= endDate - maximumProjectEndDate;
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
                ResourceCapacityTracker tracker = resourceCapacityTrackerMap.get(
                        resourceRequirement.getResource());
                hardScore -= tracker.getHardScore();
                tracker.retract(resourceRequirement, allocation);
                hardScore += tracker.getHardScore();
            }
        }
        // Total project delay and total make span
        if (allocation.getJob().getJobType() == JobType.SINK) {
            Integer endDate = allocation.getEndDate();
            if (endDate != null) {
                Project project = allocation.getProject();
                projectEndDateMap.remove(project);
                // Total project delay
                soft0Score += endDate - project.getCriticalPathEndDate();
                // Total make span
                if (endDate == maximumProjectEndDate) {
                    updateMaximumProjectEndDate();
                    soft1Score += endDate - maximumProjectEndDate;
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
		//logger.debug("hardScore: {}, soft0Score: {}, soft1Score: {}", hardScore, soft0Score, soft1Score);                
        return BendableScore.valueOf(new int[] {hardScore}, new int[] {soft0Score, soft1Score});
    }


}
