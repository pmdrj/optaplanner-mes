/**
 * 
 */
package org.optaplanner.mes.projectjobscheduling.solver.score.resourcegap;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.mes.common.app.LoggingMain;
import org.optaplanner.mes.projectjobscheduling.domain.Allocation;
import org.optaplanner.mes.projectjobscheduling.domain.resource.Resource;

/**
 * @author tbista
 *
 */
public class ResourceGapTracker extends LoggingMain {
	protected Resource resource;
	private int sumGap;

	public ResourceGapTracker(Resource resource) {
		this.resource = resource;
	}

	public int getGap() {
		sumGap = 0;
		logger.trace("ResourceGapTracker, getGap for mesMachineNr: {}", resource.getMesMachineNr());
		List<Allocation> allocationList = new ArrayList<Allocation>(resource.getAllocationList());
		allocationList.sort(Allocation.StartDateComparator);
		Allocation prevAllocation = null;
		for (Allocation allocation : allocationList) {
			int prevEndDate = (prevAllocation == null) ? 0 : prevAllocation.getEndDate();
			int currStartDate = (allocation == null) ? 0 : allocation.getStartDate();			
			if (prevAllocation == null) {
				prevAllocation = allocation;
			} else if (prevEndDate <= currStartDate) {
				int gap = currStartDate - prevEndDate;
				logger.trace("    gap between mesOperations {} and {}: {}", prevAllocation.getJob().getMesOperationNr(), allocation.getJob().getMesOperationNr(), gap);			
				sumGap += gap;
				prevAllocation = allocation;
			}
		}
		logger.trace("    sumGap: {}", sumGap);
		return sumGap;
	}
}
