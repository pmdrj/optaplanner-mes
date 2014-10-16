************************************************************************
file with basedata            :
initial value random generator: 7749604821
************************************************************************
projects                      : 1
jobs (incl. supersource/sink ): 5
horizon                       : 0
RESOURCES
  - renewable                 : 15 R
  - nonrenewable              :  0 N
  - doubly constrained        :  0 D
************************************************************************
PROJECT INFORMATION:
pronr.  #jobs rel.date duedate tardcost  MPM-Time
    1       3        0       0        0         0
************************************************************************
PRECEDENCE RELATIONS:
jobnr.    #modes  #successors   successors
    1          1            1   2
    2          1            1   3
    3          1            1   4
    4          1            1   5
    5          1            0
************************************************************************
REQUESTS/DURATIONS:
jobnr. mode duration       R 1   R 2   R 3   R 4   R 5   R 6   R 7   R 8   R 9   R 10   R 11   R 12   R 13   R 14   R 15
------------------------------------------------------------------------
    1     1        0         0     0     0     0     0     0     0     0     0      0      0      0      0      0      0
    2     1       37         1     0     0     0     0     0     0     0     0      0      0      0      0      0      0
    3     1       13         0     0     1     0     0     0     0     0     0      0      0      0      0      0      0
    4     1       66         0     0     0     0     0     0     0     0     0      0      0      0      1      0      0
    5     1        0         0     0     0     0     0     0     0     0     0      0      0      0      0      0      0
************************************************************************
RESOURCEAVAILABILITIES:
   R 1   R 2   R 3   R 4   R 5   R 6   R 7   R 8   R 9   R 10   R 11   R 12   R 13   R 14   R 15
     0     0     0     0     0     0     0     0     0      0      0      0      0      0      0
************************************************************************




MES extensions...
To force standard mode and preserve other mes mappings (scheduling_id, operations, machines)
remove or spoil any allocation in JOBALLOCATIONS section (some content between -----... and bottom *****...).


JOBALLOCATIONS:
jobNumber    executionModeNumber    predecessorsDoneDate           delay
------------------------------------------------------------------------
        1                      1                       0               0
        2                      1                       0               0
        3                      1                      37               0
        4                      1                      50               0
        5                      1                     116               0
************************************************************************


MESSCHEDULINGSESSION:
schedulingId           timeScale
------------------------------------------------------------------------
          17                1440
************************************************************************


JOB2MESOPERATION:
jobNumber            operationId     operationNr
------------------------------------------------------------------------
        2                  26702     PRA/2014/09/014455-26702
        3                  26701     ODG/PRA/2014/09/019062-26701
        4                  26017     PAK/2014/09/004879-26017
************************************************************************


RESOURCE2MESMACHINE:
resNumber              machineId     machineNr
------------------------------------------------------------------------
        1                    101     PIEC_01
        2                    102     PIEC_02
        3                    113     VT_SILOS
        4                      4     Linia_01
        5                      5     Linia_03
        6                      6     Linia_02
        7                      7     Linia_04
        8                      8     Linia_05
        9                     10     Linia_06
       10                     11     Linia_07
       11                     12     Linia_08
       12                     13     Linia_09
       13                     14     Linia_10
       14                     15     Linia_11
       15                    236     Linia_12
************************************************************************
