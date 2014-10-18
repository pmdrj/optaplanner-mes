update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 0 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 160 / 1440, 
    sp.machine_id = 102 
where sp.scheduling_id = 15 and sp.operation_id = 26134;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 0 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 74 / 1440, 
    sp.machine_id = 101 
where sp.scheduling_id = 15 and sp.operation_id = 26130;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 74 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 100 / 1440, 
    sp.machine_id = 101 
where sp.scheduling_id = 15 and sp.operation_id = 26144;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 100 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 280 / 1440, 
    sp.machine_id = 101 
where sp.scheduling_id = 15 and sp.operation_id = 26138;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 160 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 177 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26135;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 280 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 297 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26139;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 177 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 230 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26140;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 297 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 350 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26141;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 74 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 103 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26131;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 103 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 120 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26145;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 120 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 167 / 1440, 
    sp.machine_id = 112 
where sp.scheduling_id = 15 and sp.operation_id = 26143;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 350 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 584 / 1440, 
    sp.machine_id = 112 
where sp.scheduling_id = 15 and sp.operation_id = 26137;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 103 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 230 / 1440, 
    sp.machine_id = 110 
where sp.scheduling_id = 15 and sp.operation_id = 26129;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 230 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 542 / 1440, 
    sp.machine_id = 110 
where sp.scheduling_id = 15 and sp.operation_id = 26133;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 167 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 169 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26156;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 169 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 177 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26155;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 177 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 185 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26142;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 584 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 654 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26136;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 654 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 724 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26132;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 230 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 259 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26128;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 724 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 1190 / 1440, 
    sp.machine_id = 4 
where sp.scheduling_id = 15 and sp.operation_id = 26023;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 185 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 468 / 1440, 
    sp.machine_id = 15 
where sp.scheduling_id = 15 and sp.operation_id = 26078;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 654 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 1120 / 1440, 
    sp.machine_id = 5 
where sp.scheduling_id = 15 and sp.operation_id = 26024;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 259 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 520 / 1440, 
    sp.machine_id = 12 
where sp.scheduling_id = 15 and sp.operation_id = 26020;

