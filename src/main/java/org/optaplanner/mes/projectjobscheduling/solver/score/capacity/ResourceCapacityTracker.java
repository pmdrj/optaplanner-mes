package org.optaplanner.mes.projectjobscheduling.solver.score.capacity;

import org.optaplanner.mes.projectjobscheduling.domain.Allocation;
import org.optaplanner.mes.projectjobscheduling.domain.ResourceRequirement;
import org.optaplanner.mes.projectjobscheduling.domain.resource.Resource;

public abstract class ResourceCapacityTracker {

    protected Resource resource;

    public ResourceCapacityTracker(Resource resource) {
        this.resource = resource;
    }

    public abstract void insert(ResourceRequirement resourceRequirement, Allocation allocation);

    public abstract void retract(ResourceRequirement resourceRequirement, Allocation allocation);

    public abstract int getHardScore();

}
