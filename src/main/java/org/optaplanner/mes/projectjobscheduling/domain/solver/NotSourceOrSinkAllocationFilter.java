package org.optaplanner.mes.projectjobscheduling.domain.solver;

import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionFilter;
import org.optaplanner.core.impl.score.director.ScoreDirector;
import org.optaplanner.mes.projectjobscheduling.domain.Allocation;
import org.optaplanner.mes.projectjobscheduling.domain.JobType;

public class NotSourceOrSinkAllocationFilter implements SelectionFilter<Allocation> {

    public boolean accept(ScoreDirector scoreDirector, Allocation allocation) {
        JobType jobType = allocation.getJob().getJobType();
        return jobType != JobType.SOURCE && jobType != JobType.SINK;
    }

}
