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

import java.util.List;

import org.optaplanner.mes.common.domain.AbstractPersistable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@SuppressWarnings("serial")
@XStreamAlias("PjsJob")
public class Job extends AbstractPersistable {

    private Project project;
    private JobType jobType;
    private List<ExecutionMode> executionModeList;
    private List<Job> successorJobList;    
    private int initialPredecessorsDoneDate;
    private ExecutionMode initialExecutionMode;
    private int initialDelay;    
    private int mesOperationId;

	public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public List<ExecutionMode> getExecutionModeList() {
        return executionModeList;
    }

    public void setExecutionModeList(List<ExecutionMode> executionModeList) {
        this.executionModeList = executionModeList;
    }

    public List<Job> getSuccessorJobList() {
        return successorJobList;
    }

    public void setSuccessorJobList(List<Job> successorJobList) {
        this.successorJobList = successorJobList;
    }
 
	public int getInitialPredecessorsDoneDate() {
		return initialPredecessorsDoneDate;
	}

	public void setInitialPredecessorsDoneDate(int initialPredecessorsDoneDate) {
		this.initialPredecessorsDoneDate = initialPredecessorsDoneDate;
	}

	public ExecutionMode getInitialExecutionMode() {
		return initialExecutionMode;
	}

	public void setInitialExecutionMode(ExecutionMode initialExecutionMode) {
		this.initialExecutionMode = initialExecutionMode;
	}
	
	public int getInitialDelay() {
		return initialDelay;
	}

	public void setInitialDelay(int initialDelay) {
		this.initialDelay = initialDelay;
	}

	public int getMesOperationId() {
		return mesOperationId;
	}

	public void setMesOperationId(int mesOperationId) {
		this.mesOperationId = mesOperationId;
	}	
	

    // ************************************************************************
    // Complex methods
    // ************************************************************************

}
