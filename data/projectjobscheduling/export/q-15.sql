update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 0 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 180 / 1440, 
    sp.machine_id = 101 
where sp.scheduling_id = 15 and sp.operation_id = 26134;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 0 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 65 / 1440, 
    sp.machine_id = 102 
where sp.scheduling_id = 15 and sp.operation_id = 26130;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 180 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 206 / 1440, 
    sp.machine_id = 101 
where sp.scheduling_id = 15 and sp.operation_id = 26144;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 65 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 225 / 1440, 
    sp.machine_id = 102 
where sp.scheduling_id = 15 and sp.operation_id = 26138;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 233 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 250 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26135;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 250 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 267 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26139;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 180 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 233 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26140;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 267 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 320 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26141;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 65 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 94 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26131;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 320 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 337 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26145;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 337 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 399 / 1440, 
    sp.machine_id = 109 
where sp.scheduling_id = 15 and sp.operation_id = 26143;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 320 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 632 / 1440, 
    sp.machine_id = 110 
where sp.scheduling_id = 15 and sp.operation_id = 26137;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 94 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 190 / 1440, 
    sp.machine_id = 112 
where sp.scheduling_id = 15 and sp.operation_id = 26129;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 250 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 484 / 1440, 
    sp.machine_id = 112 
where sp.scheduling_id = 15 and sp.operation_id = 26133;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 399 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 401 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26156;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 401 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 409 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26155;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 409 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 417 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26142;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 632 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 702 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26136;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 484 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 554 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26132;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 190 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 219 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26128;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 554 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 1020 / 1440, 
    sp.machine_id = 4 
where sp.scheduling_id = 15 and sp.operation_id = 26023;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 417 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 700 / 1440, 
    sp.machine_id = 15 
where sp.scheduling_id = 15 and sp.operation_id = 26078;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 702 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 1168 / 1440, 
    sp.machine_id = 5 
where sp.scheduling_id = 15 and sp.operation_id = 26024;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 219 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 480 / 1440, 
    sp.machine_id = 12 
where sp.scheduling_id = 15 and sp.operation_id = 26020;

