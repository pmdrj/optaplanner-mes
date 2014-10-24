package org.optaplanner.mes.projectjobscheduling.solver.score.capacity;

import java.util.HashMap;
import java.util.Map;

import org.optaplanner.mes.projectjobscheduling.domain.Allocation;
import org.optaplanner.mes.projectjobscheduling.domain.ResourceRequirement;
import org.optaplanner.mes.projectjobscheduling.domain.resource.Resource;

public class RenewableResourceCapacityTracker extends ResourceCapacityTracker {

	protected int capacityEveryDay;

	protected Map<Integer, Integer> usedPerDay;
	protected int hardScore;

	public RenewableResourceCapacityTracker(Resource resource) {
		super(resource);
		if (!resource.isRenewable()) {
			throw new IllegalArgumentException("The resource (" + resource + ") is expected to be renewable.");
		}
		capacityEveryDay = resource.getCapacity();
		usedPerDay = new HashMap<Integer, Integer>();
		hardScore = 0;
	}

	@Override
	public void insert(ResourceRequirement resourceRequirement, Allocation allocation) {
		int startDate = allocation.getStartDate();
		int endDate = allocation.getEndDate();
		int requirement = resourceRequirement.getRequirement();
		for (int i = startDate; i < endDate; i++) {
			Integer used = usedPerDay.get(i);
			if (used == null) {
				used = 0;
			}
			if (used > capacityEveryDay) {
				hardScore += (used - capacityEveryDay);
			}
			used += requirement;
			if (used > capacityEveryDay) {
				hardScore -= (used - capacityEveryDay);
			}
			usedPerDay.put(i, used);
		}

		Long jobId = allocation.getJob().getId();
		Allocation toRemoveAllocation = getAllocationToRemoveFromResource(jobId);
		while (toRemoveAllocation != null) {
			logger.trace("Before putting new allocation to resource: {} remove allocation: {}", resource.toString(), toRemoveAllocation.toString());
			resource.getAllocationList().remove(toRemoveAllocation);
			toRemoveAllocation = getAllocationToRemoveFromResource(jobId);
		}

		logger.trace("On resource: {} putting allocation: {}", resource.toString(), allocation.toString());
		resource.getAllocationList().add(allocation);

		logger.trace("After insert allocation list on resource {}: {}", resource.toString(), getAllocationListOnResource());
	}

	@Override
	public void retract(ResourceRequirement resourceRequirement, Allocation allocation) {
		int startDate = allocation.getStartDate();
		int endDate = allocation.getEndDate();
		int requirement = resourceRequirement.getRequirement();
		for (int i = startDate; i < endDate; i++) {
			Integer used = usedPerDay.get(i);
			if (used == null) {
				used = 0;
			}
			if (used > capacityEveryDay) {
				hardScore += (used - capacityEveryDay);
			}
			used -= requirement;
			if (used > capacityEveryDay) {
				hardScore -= (used - capacityEveryDay);
			}
			usedPerDay.put(i, used);
		}

		Long jobId = allocation.getJob().getId();
		Allocation toRemoveAllocation = getAllocationToRemoveFromResource(jobId);
		while (toRemoveAllocation != null) {
			logger.trace("From resource: {} remove allocation: {}", resource.toString(), toRemoveAllocation.toString());
			resource.getAllocationList().remove(toRemoveAllocation);
			toRemoveAllocation = getAllocationToRemoveFromResource(jobId);
		}
		logger.trace("Afetr retract allocation list on resource {}: {}", resource.toString(), getAllocationListOnResource());
	}

	@Override
	public int getHardScore() {
		return hardScore;
	}

	private String getAllocationListOnResource() {
		String theList = "";
		for (Allocation a : this.resource.getAllocationList()) {
			if (theList != "") {
				theList += ", ";
			}
			theList += a.toString();
		}
		return theList;
	}

	private Allocation getAllocationToRemoveFromResource(Long jobId) {
		Allocation toRemoveAllocation = null;
		for (Allocation resourceAllocation : resource.getAllocationList()) {
			if (resourceAllocation.getJob().getId() == jobId) {
				toRemoveAllocation = resourceAllocation;
				break;
			}
		}
		return toRemoveAllocation;
	}

}
