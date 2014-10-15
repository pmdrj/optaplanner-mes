<?xml version="1.0" encoding="UTF-8"?>
<plannerBenchmark>
  <benchmarkDirectory>local/data/projectjobscheduling/template</benchmarkDirectory>
  <parallelBenchmarkCount>AUTO</parallelBenchmarkCount>
  <warmUpSecondsSpentLimit>30</warmUpSecondsSpentLimit>

  <inheritedSolverBenchmark>
    <problemBenchmarks>
      <xStreamAnnotatedClass>org.optaplanner.mes.projectjobscheduling.domain.Schedule</xStreamAnnotatedClass>      
      <problemStatisticType>BEST_SCORE</problemStatisticType>
    </problemBenchmarks>

    <solver>
      <solutionClass>org.optaplanner.mes.projectjobscheduling.domain.Schedule</solutionClass>
      <entityClass>org.optaplanner.mes.projectjobscheduling.domain.Allocation</entityClass>

      <scoreDirectorFactory>
        <scoreDefinitionType>BENDABLE</scoreDefinitionType>
        <bendableHardLevelsSize>1</bendableHardLevelsSize>
        <bendableSoftLevelsSize>2</bendableSoftLevelsSize>
        <incrementalScoreCalculatorClass>org.optaplanner.mes.projectjobscheduling.solver.score.ProjectJobSchedulingIncrementalScoreCalculator</incrementalScoreCalculatorClass>
      </scoreDirectorFactory>
      <termination>
        <secondsSpentLimit>290</secondsSpentLimit>
      </termination>
    </solver>
  </inheritedSolverBenchmark>

<#list [500, 1000, 2000] as lateAcceptanceSize>
  <solverBenchmark>
    <name>LA ${lateAcceptanceSize}</name>
    <solver>
      <constructionHeuristic>
        <constructionHeuristicType>FIRST_FIT</constructionHeuristicType>
      </constructionHeuristic>
      <localSearch>
        <unionMoveSelector>
          <changeMoveSelector>
            <valueSelector>
              <variableName>executionMode</variableName>
            </valueSelector>
          </changeMoveSelector>
          <changeMoveSelector>
            <valueSelector>
              <variableName>delay</variableName>
            </valueSelector>
          </changeMoveSelector>
        </unionMoveSelector>
        <acceptor>
          <entityTabuRatio>0.2</entityTabuRatio>
          <lateAcceptanceSize>${lateAcceptanceSize}</lateAcceptanceSize>
        </acceptor>
        <forager>
          <acceptedCountLimit>4</acceptedCountLimit>
        </forager>
      </localSearch>
    </solver>
  </solverBenchmark>
</#list>
</plannerBenchmark>
