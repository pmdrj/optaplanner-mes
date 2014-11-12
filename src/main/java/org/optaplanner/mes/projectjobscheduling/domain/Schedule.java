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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.score.buildin.bendable.BendableScore;
import org.optaplanner.mes.common.domain.AbstractPersistable;
import org.optaplanner.mes.projectjobscheduling.domain.resource.Resource;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@SuppressWarnings("serial")
@PlanningSolution
@XStreamAlias("PjsSchedule")
public class Schedule extends AbstractPersistable implements Solution<BendableScore> {

	private List<Project> projectList;
	private List<Job> jobList;
	private List<ExecutionMode> executionModeList;
	private List<Resource> resourceList;
	private List<ResourceRequirement> resourceRequirementList;
	private List<Allocation> allocationList;
	private int mesSchedulingId;
	private int mesTimeScale;
	private Map<ScoreDefCode, ScoreDef> scoreDefMap;
	private ScoreDef[] hardScoreDefArray;
	private ScoreDef[] softScoreDefArray;
	private boolean readFromDb;
	private String dbConnectString;

	public Schedule() {
		super();
		if (!readFromDb) {
			scoreDefMap = new HashMap<ScoreDefCode, ScoreDef>();
			scoreDefMap.put(ScoreDefCode.RESOURCE, new ScoreDef(ScoreDefType.HARD, 0, "Resource capacity", ""));
			scoreDefMap.put(ScoreDefCode.SPAN, new ScoreDef(ScoreDefType.SOFT, 2, "Make span", ""));
			scoreDefMap.put(ScoreDefCode.DELAY, new ScoreDef(ScoreDefType.SOFT, 4, "Project delay", ""));
			createScoreHierarchy(scoreDefMap);
		}

	}

	public void createScoreHierarchy(Map<ScoreDefCode, ScoreDef> scoreDefMap) {
		this.scoreDefMap = scoreDefMap;

		List<ScoreDef> scoreDefList = new ArrayList<ScoreDef>(scoreDefMap.values());
		scoreDefList.sort(ScoreDef.ScoreLevelComparator);
		int hardScoreCount = 0;
		int softScoreCount = 0;
		for (ScoreDef scoreDef : scoreDefList) {
			if (scoreDef.getType() == ScoreDefType.HARD) {
				hardScoreCount++;
			} else if (scoreDef.getType() == ScoreDefType.SOFT) {
				softScoreCount++;
			}
		}

		int hardIdx = 0;
		int softIdx = 0;
		hardScoreDefArray = new ScoreDef[hardScoreCount];
		softScoreDefArray = new ScoreDef[softScoreCount];
		for (ScoreDef scoreDef : scoreDefList) {
			if (scoreDef.getType() == ScoreDefType.HARD) {
				hardScoreDefArray[hardIdx++] = scoreDef;
			} else if (scoreDef.getType() == ScoreDefType.SOFT) {
				softScoreDefArray[softIdx++] = scoreDef;
			}
		}
	}

	private BendableScore score;

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public List<Job> getJobList() {
		return jobList;
	}

	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}

	public List<ExecutionMode> getExecutionModeList() {
		return executionModeList;
	}

	public void setExecutionModeList(List<ExecutionMode> executionModeList) {
		this.executionModeList = executionModeList;
	}

	public List<Resource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}

	public List<ResourceRequirement> getResourceRequirementList() {
		return resourceRequirementList;
	}

	public void setResourceRequirementList(List<ResourceRequirement> resourceRequirementList) {
		this.resourceRequirementList = resourceRequirementList;
	}

	@PlanningEntityCollectionProperty
	public List<Allocation> getAllocationList() {
		return allocationList;
	}

	public void setAllocationList(List<Allocation> allocationList) {
		this.allocationList = allocationList;
	}

	public BendableScore getScore() {
		return score;
	}

	public void setScore(BendableScore score) {
		this.score = score;
	}

	public int getMesSchedulingId() {
		return mesSchedulingId;
	}

	public void setMesSchedulingId(int mesSchedulingId) {
		this.mesSchedulingId = mesSchedulingId;
	}

	public int getMesTimeScale() {
		return mesTimeScale;
	}

	public void setMesTimeScale(int mesTimeScale) {
		this.mesTimeScale = mesTimeScale;
	}

	public Map<ScoreDefCode, ScoreDef> getScoreDefMap() {
		return scoreDefMap;
	}

	public ScoreDef[] getHardScoreDefArray() {
		return hardScoreDefArray;
	}

	public ScoreDef[] getSoftScoreDefArray() {
		return softScoreDefArray;
	}

	public boolean isReadFromDb() {
		return readFromDb;
	}

	public void setReadFromDb(boolean readFromDb) {
		this.readFromDb = readFromDb;
	}

	public String getDbConnectString() {
		return dbConnectString;
	}

	public void setDbConnectString(String dbConnectString) {
		this.dbConnectString = dbConnectString;
	}

	// ************************************************************************
	// Complex methods
	// ************************************************************************

	public Collection<? extends Object> getProblemFacts() {
		List<Object> facts = new ArrayList<Object>();
		facts.addAll(projectList);
		facts.addAll(jobList);
		facts.addAll(executionModeList);
		facts.addAll(resourceList);
		facts.addAll(resourceRequirementList);
		// Do not add the planning entity's (allocationList) because that will
		// be done automatically
		return facts;
	}

}