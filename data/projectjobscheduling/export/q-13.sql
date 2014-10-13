update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 0 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 24 / 1440, 
    sp.machine_id = 102 
where sp.scheduling_id = 13 and sp.operation_id = 27614;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 24 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 37 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 13 and sp.operation_id = 27615;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 37 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 81 / 1440, 
    sp.machine_id = 112 
where sp.scheduling_id = 13 and sp.operation_id = 27613;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 81 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 94 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 13 and sp.operation_id = 27612;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 94 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 160 / 1440, 
    sp.machine_id = 14 
where sp.scheduling_id = 13 and sp.operation_id = 26881;

