update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 1 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 25 / 1440, 
    sp.machine_id = 101 
where sp.scheduling_id = 13 and sp.operation_id = 27614;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 26 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 39 / 1440, 
    sp.machine_id = 113 
where sp.scheduling_id = 13 and sp.operation_id = 27615;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 40 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 84 / 1440, 
    sp.machine_id = 112 
where sp.scheduling_id = 13 and sp.operation_id = 27613;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 85 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 98 / 1440, 
    sp.machine_id = 114 
where sp.scheduling_id = 13 and sp.operation_id = 27612;

update qmes_ejs_scheduling_position sp set 
    sp.start_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 99 / 1440, 
    sp.stop_date = (select ss.begin_date from qmes_ejs_scheduling_session ss where ss.scheduling_id = 13) + 165 / 1440, 
    sp.machine_id = 14 
where sp.scheduling_id = 13 and sp.operation_id = 26881;

