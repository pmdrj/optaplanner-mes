package org.optaplanner.mes.projectjobscheduling.domain;

public enum ScoreDefCode {
	RESOURCE, // resource insufficiency
	FREE_SPACE, // time from last operation end to session end
	SPAN, // time from first operation start to last operation end
	GAP, // sum gaps on machines
	DELAY // sum delay of subsequent operations
}
