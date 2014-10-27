/**
 * 
 */
package org.optaplanner.mes.projectjobscheduling.domain;

import java.util.Comparator;

/**
 * @author tbista
 *
 */
public class ScoreDef {
	private ScoreDefType type;
	private int level;
	private String name;
	private String description;	
	private int value;

	public ScoreDef(ScoreDefType type, int level, String name, String description) {
		this.type = type;
		this.level = level;
		this.name = name;
		this.description = description;
	}		
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void add(int value) {
		this.value += value;
	}
	public void subtruct(int value) {
		this.value -= value;
	}
	
	public ScoreDefType getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}
	
	public int getLevel() {
		return level;
	}

	public static Comparator<ScoreDef> ScoreLevelComparator = new Comparator<ScoreDef>() {
		public int compare(ScoreDef scoreDef1, ScoreDef scoreDef2) {
			Integer level1 = (scoreDef1 == null) ? Integer.MIN_VALUE : scoreDef1.getLevel();
			Integer level2 = (scoreDef2 == null) ? Integer.MIN_VALUE : scoreDef2.getLevel();
			return level1.compareTo(level2);
		}
	};
}
