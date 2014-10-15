update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 0 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 160 / 1440, 
    sp.machine_id = 102 
where sp.scheduling_id = 15 and sp.operation_id = 26134;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 426 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 491 / 1440, 
    sp.machine_id = 102 
where sp.scheduling_id = 15 and sp.operation_id = 26130;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 21 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 47 / 1440, 
    sp.machine_id = 101 
where sp.scheduling_id = 15 and sp.operation_id = 26144;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 55 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 235 / 1440, 
    sp.machine_id = 101 
where sp.scheduling_id = 15 and sp.operation_id = 26138;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 160 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 177 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26135;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 235 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 252 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26139;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 177 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 230 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26140;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 262 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 315 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26141;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 502 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 531 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26131;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 56 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 73 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26145;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 249 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 296 / 1440, 
    sp.machine_id = 112 
where sp.scheduling_id = 15 and sp.operation_id = 26143;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 315 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 549 / 1440, 
    sp.machine_id = 112 
where sp.scheduling_id = 15 and sp.operation_id = 26137;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 624 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 720 / 1440, 
    sp.machine_id = 112 
where sp.scheduling_id = 15 and sp.operation_id = 26129;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 230 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 542 / 1440, 
    sp.machine_id = 110 
where sp.scheduling_id = 15 and sp.operation_id = 26133;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 725 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 727 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26156;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 445 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 453 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26155;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 524 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 532 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26142;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 549 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 619 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26136;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 637 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 707 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26132;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 741 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 770 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26128;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 707 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 1173 / 1440, 
    sp.machine_id = 4 
where sp.scheduling_id = 15 and sp.operation_id = 26023;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 849 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 1132 / 1440, 
    sp.machine_id = 15 
where sp.scheduling_id = 15 and sp.operation_id = 26078;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 686 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 1152 / 1440, 
    sp.machine_id = 6 
where sp.scheduling_id = 15 and sp.operation_id = 26024;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 882 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 1143 / 1440, 
    sp.machine_id = 12 
where sp.scheduling_id = 15 and sp.operation_id = 26020;

