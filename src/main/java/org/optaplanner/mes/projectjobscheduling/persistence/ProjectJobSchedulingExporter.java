package org.optaplanner.mes.projectjobscheduling.persistence;

import java.io.IOException;

import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.mes.common.persistence.AbstractTxtSolutionExporter;
import org.optaplanner.mes.projectjobscheduling.domain.Allocation;
import org.optaplanner.mes.projectjobscheduling.domain.JobType;
import org.optaplanner.mes.projectjobscheduling.domain.Schedule;

/**
 * @author tbista
 *
 */
public class ProjectJobSchedulingExporter extends AbstractTxtSolutionExporter {

	private static final String OUTPUT_FILE_SUFFIX = "sql";

	public static void main(String[] args) {
		new ProjectJobSchedulingExporter().convertAll();
	}

	public ProjectJobSchedulingExporter() {
		super(new ProjectJobSchedulingDao());
	}

	@Override
	public String getOutputFileSuffix() {
		return OUTPUT_FILE_SUFFIX;
	}

	public TxtOutputBuilder createTxtOutputBuilder() {
		return new ProjectJobSchedulingOutputBuilder();
	}

	public static class ProjectJobSchedulingOutputBuilder extends TxtOutputBuilder {

		private Schedule schedule;

		public void setSolution(Solution<?> solution) {
			schedule = (Schedule) solution;
		}

		public void writeSolution() throws IOException {
			String msg;
			int machineId;

			if (schedule.getMesSchedulingId() > 0) {
				for (Allocation allocation : schedule.getAllocationList()) {
					if (allocation.getJobType() == JobType.STANDARD) {
						machineId = allocation.getExecutionMode().getResourceRequirementList().get(0).getResource().getMesMachineId();

						msg = "update qmes_ejs_scheduling_position sp set \r\n";
						msg += "    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = "
								+ schedule.getMesSchedulingId() + ") + " + allocation.getStartDate() + " / " + schedule.getMesTimeScale() + ", \r\n";
						msg += "    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = "
								+ schedule.getMesSchedulingId() + ") + " + allocation.getEndDate() + " / " + schedule.getMesTimeScale() + ", \r\n";
						msg += "    sp.machine_id = " + machineId + " \r\n";
						msg += "where sp.scheduling_id = " + schedule.getMesSchedulingId() + " ";
						msg += "and sp.operation_id = " + allocation.getJob().getMesOperationId() + ";";

						bufferedWriter.write(msg + "\r\n\r\n");
					}
				}
			} else {
				bufferedWriter.write("Mes extension was not set." + "\r\n");
			}
		}
	}
}
