update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 27 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 187 / 1440, 
    sp.machine_id = 102 
where sp.scheduling_id = 15 and sp.operation_id = 26134;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 50 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 124 / 1440, 
    sp.machine_id = 101 
where sp.scheduling_id = 15 and sp.operation_id = 26130;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 3 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 29 / 1440, 
    sp.machine_id = 101 
where sp.scheduling_id = 15 and sp.operation_id = 26144;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 256 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 416 / 1440, 
    sp.machine_id = 102 
where sp.scheduling_id = 15 and sp.operation_id = 26138;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 223 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 240 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26135;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 435 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 452 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26139;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 259 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 312 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26140;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 528 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 581 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26141;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 127 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 156 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26131;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 38 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 55 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 15 and sp.operation_id = 26145;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 94 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 174 / 1440, 
    sp.machine_id = 104 
where sp.scheduling_id = 15 and sp.operation_id = 26143;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 601 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 835 / 1440, 
    sp.machine_id = 112 
where sp.scheduling_id = 15 and sp.operation_id = 26137;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 216 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 343 / 1440, 
    sp.machine_id = 110 
where sp.scheduling_id = 15 and sp.operation_id = 26129;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 313 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 713 / 1440, 
    sp.machine_id = 103 
where sp.scheduling_id = 15 and sp.operation_id = 26133;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 206 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 208 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26156;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 185 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 193 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26155;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 209 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 217 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26142;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 872 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 942 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26136;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 757 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 827 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26132;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 351 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 380 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 15 and sp.operation_id = 26128;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 850 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 1316 / 1440, 
    sp.machine_id = 6 
where sp.scheduling_id = 15 and sp.operation_id = 26023;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 230 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 513 / 1440, 
    sp.machine_id = 15 
where sp.scheduling_id = 15 and sp.operation_id = 26078;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 951 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 1417 / 1440, 
    sp.machine_id = 5 
where sp.scheduling_id = 15 and sp.operation_id = 26024;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 593 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 15) + 854 / 1440, 
    sp.machine_id = 12 
where sp.scheduling_id = 15 and sp.operation_id = 26020;

