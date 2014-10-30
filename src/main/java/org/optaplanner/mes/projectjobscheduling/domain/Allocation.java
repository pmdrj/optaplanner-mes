/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.mes.projectjobscheduling.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.valuerange.CountableValueRange;
import org.optaplanner.core.api.domain.valuerange.ValueRangeFactory;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.domain.variable.CustomShadowVariable;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.mes.common.domain.AbstractPersistable;
import org.optaplanner.mes.projectjobscheduling.domain.solver.DelayStrengthComparator;
import org.optaplanner.mes.projectjobscheduling.domain.solver.ExecutionModeStrengthWeightFactory;
import org.optaplanner.mes.projectjobscheduling.domain.solver.NotSourceOrSinkAllocationFilter;
import org.optaplanner.mes.projectjobscheduling.domain.solver.PredecessorsDoneDateUpdatingVariableListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@SuppressWarnings("serial")
@PlanningEntity(movableEntitySelectionFilter = NotSourceOrSinkAllocationFilter.class)
@XStreamAlias("PjsAllocation")
public class Allocation extends AbstractPersistable {

	protected final transient Logger logger = LoggerFactory.getLogger(getClass());

	private Job job;

	private Allocation sourceAllocation;
	private Allocation sinkAllocation;
	private List<Allocation> predecessorAllocationList;
	private List<Allocation> successorAllocationList;

	// Planning variables: changes during planning, between score calculations.
	private ExecutionMode executionMode;
	private Integer delay; // In days

	// Shadow variables
	private Integer predecessorsDoneDate;

	private Long delayDecisionNr = 0L;

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Allocation getSourceAllocation() {
		return sourceAllocation;
	}

	public void setSourceAllocation(Allocation sourceAllocation) {
		this.sourceAllocation = sourceAllocation;
	}

	public Allocation getSinkAllocation() {
		return sinkAllocation;
	}

	public void setSinkAllocation(Allocation sinkAllocation) {
		this.sinkAllocation = sinkAllocation;
	}

	public List<Allocation> getPredecessorAllocationList() {
		return predecessorAllocationList;
	}

	public void setPredecessorAllocationList(List<Allocation> predecessorAllocationList) {
		this.predecessorAllocationList = predecessorAllocationList;
	}

	public List<Allocation> getSuccessorAllocationList() {
		return successorAllocationList;
	}

	public void setSuccessorAllocationList(List<Allocation> successorAllocationList) {
		this.successorAllocationList = successorAllocationList;
	}

	@PlanningVariable(valueRangeProviderRefs = { "executionModeRange" }, strengthWeightFactoryClass = ExecutionModeStrengthWeightFactory.class)
	public ExecutionMode getExecutionMode() {
		return executionMode;
	}

	public void setExecutionMode(ExecutionMode executionMode) {
		this.executionMode = executionMode;
	}

	@PlanningVariable(valueRangeProviderRefs = { "delayRange" }, strengthComparatorClass = DelayStrengthComparator.class)
	public Integer getDelay() {
		return delay;
	}

	public void setDelay(Integer delay) {
		this.delay = delay;
	}

	@CustomShadowVariable(variableListenerClass = PredecessorsDoneDateUpdatingVariableListener.class, sources = { @CustomShadowVariable.Source(variableName = "executionMode"),
			@CustomShadowVariable.Source(variableName = "delay") })
	public Integer getPredecessorsDoneDate() {
		return predecessorsDoneDate;
	}

	public void setPredecessorsDoneDate(Integer predecessorsDoneDate) {
		this.predecessorsDoneDate = predecessorsDoneDate;
	}

	@Override
	public String toString() {
		String mesOperationNr = ", mesOperationNr: " + job.getMesOperationNr();
		String atMesMachineNr = "";
		String atDelay = "";
		if (this.executionMode != null && !this.executionMode.getResourceRequirementList().isEmpty()) {
			atMesMachineNr = ", mesMachineNr: " + this.executionMode.getResourceRequirementList().get(0).getResource().getMesMachineNr();
		}
		if (this.delay != null) {
			atDelay = ", delay: " + this.delay.toString();
		}
		return "[id: " + this.id.toString() + atDelay + mesOperationNr + atMesMachineNr + "]";
	}

	// ************************************************************************
	// Complex methods
	// ************************************************************************

	public Integer getStartDate() {
		if (predecessorsDoneDate == null) {
			return null;
		}
		return predecessorsDoneDate + (delay == null ? 0 : delay);
	}

	public Integer getEndDate() {
		if (predecessorsDoneDate == null) {
			return null;
		}
		return predecessorsDoneDate + (delay == null ? 0 : delay) + (executionMode == null ? 0 : executionMode.getDuration());
	}

	public Project getProject() {
		return job.getProject();
	}

	public Schedule getSchedule() {
		return job.getProject().getSchedule();
	}

	public int getProjectCriticalPathEndDate() {
		return job.getProject().getCriticalPathEndDate();
	}

	public JobType getJobType() {
		return job.getJobType();
	}

	public String getLabel() {
		return "Job " + job.getId();
	}

	// ************************************************************************
	// Ranges
	// ************************************************************************

	@ValueRangeProvider(id = "executionModeRange")
	public List<ExecutionMode> getExecutionModeRange() {
		return job.getExecutionModeList();
	}

	@ValueRangeProvider(id = "delayRange")
	public CountableValueRange<Integer> getDelayRange() {
		return ValueRangeFactory.createIntValueRange(0, 2000, 1);
	}

	@SuppressWarnings("unused")
	private CountableValueRange<Integer> getDecreasingDelayRange() {
		delayDecisionNr += 1;
		if (logger != null)
			logger.trace("Delay decision nr: {}", delayDecisionNr);
		int from;
		int to;
		int step;
		if (delayDecisionNr < 100) {
			from = 1000;
			to = 10000;
			step = 1000;
		} else if (delayDecisionNr < 200) {
			from = 100;
			to = 10000;
			step = 100;
		} else if (delayDecisionNr < 300) {
			from = 10;
			to = 1000;
			step = 10;
		} else {
			from = 0;
			to = 100;
			step = 1;
		}
		CountableValueRange<Integer> range = ValueRangeFactory.createIntValueRange(from, to, step);

		if (logger != null)
			logger.trace("Getting delayRange from {} to {} with step {}.", from, (to - step), step);
		return range;
	}

	@SuppressWarnings("unused")
	private CountableValueRange<Integer> getRandomDelayRange() {
		Random ran = new Random();
		int x = ran.nextInt(4);
		if (logger != null)
			logger.trace("Random: {}", x);
		int from;
		int to;
		int step;
		CountableValueRange<Integer> range = null;
		if (x == 0) {
			from = 0;
			to = 10;
			step = 1;
			range = ValueRangeFactory.createIntValueRange(0, 10);
		} else {
			from = (int) Math.pow(10, x);
			to = (int) Math.pow(10, x + 1);
			step = (int) Math.pow(10, x);
			range = ValueRangeFactory.createIntValueRange(from, to, step);
		}

		if (logger != null)
			logger.trace("Getting delayRange from {} to {} with step {}.", from, (to - step), step);
		return range;
	}

	public static Comparator<Allocation> StartDateComparator = new Comparator<Allocation>() {
		public int compare(Allocation allocation1, Allocation allocation2) {
			Integer startDate1 = (allocation1 == null || allocation1.getStartDate() == null) ? 0 : allocation1.getStartDate();
			Integer startDate2 = (allocation2 == null || allocation2.getStartDate() == null) ? 0 : allocation2.getStartDate();
			return startDate1.compareTo(startDate2);
		}
	};
}
