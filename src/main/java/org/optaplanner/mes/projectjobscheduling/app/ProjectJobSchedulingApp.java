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

package org.optaplanner.mes.projectjobscheduling.app;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.mes.common.app.CommonApp;
import org.optaplanner.mes.common.persistence.AbstractSolutionExporter;
import org.optaplanner.mes.common.persistence.AbstractSolutionImporter;
import org.optaplanner.mes.common.persistence.SolutionDao;
import org.optaplanner.mes.common.swingui.SolutionPanel;
import org.optaplanner.mes.projectjobscheduling.persistence.ProjectJobSchedulingDao;
import org.optaplanner.mes.projectjobscheduling.persistence.ProjectJobSchedulingExporter;
import org.optaplanner.mes.projectjobscheduling.persistence.ProjectJobSchedulingImporter;
import org.optaplanner.mes.projectjobscheduling.swingui.ProjectJobSchedulingPanel;

public class ProjectJobSchedulingApp extends CommonApp {

    public static final String SOLVER_CONFIG
            = "org/optaplanner/mes/projectjobscheduling/solver/projectJobSchedulingSolverConfig.xml";

    public static void main(String[] args) {
        prepareSwingEnvironment();
        new ProjectJobSchedulingApp().init();
    }

    public ProjectJobSchedulingApp() {
        super("Project job scheduling",
                "Official competition name:" +
                        " multi-mode resource-constrained multi-project scheduling problem (MRCMPSP)\n\n" +
                        "Schedule all jobs in time and execution mode.\n\n" +
                        "Minimize project delays.",
                ProjectJobSchedulingPanel.LOGO_PATH);
    }

    @Override
    protected Solver createSolver() {
        SolverFactory solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);
        return solverFactory.buildSolver();
    }

    @Override
    protected SolutionPanel createSolutionPanel() {
        return new ProjectJobSchedulingPanel();
    }

    @Override
    protected SolutionDao createSolutionDao() {
        return new ProjectJobSchedulingDao();
    }

    @Override
    protected AbstractSolutionImporter createSolutionImporter() {
        return new ProjectJobSchedulingImporter();
    }
    
    @Override
    protected AbstractSolutionExporter createSolutionExporter() {
        return new ProjectJobSchedulingExporter();
    }

}
