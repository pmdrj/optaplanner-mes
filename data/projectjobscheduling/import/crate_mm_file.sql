/* ************************************************************************** */
/* Uruchamiamy z SQL*Plus (lub Command Window PL/SQL Developer) pleceniem     */
/* @[œcie¿ka do skryptu]. Pliki q-[scheduling_id].mm i q-[scheduling_id].txt  */
/* zostan¹ utworzone w tym samym katalogu, w którym jest ten skrypt.          */
/* ************************************************************************** */

set feedback off
set define on
set linesize 4000;
set heading off;

define c_scheduling_id = &scheduling_id;

prompt Getting scheduling session data...
BEGIN
    qmesp_bl_optaplanner.create_pjs_mm(p_scheduling_id => &c_scheduling_id);
END;
/

prompt Creating file q-&c_scheduling_id..mm...
set termout off;
spool ./q-&c_scheduling_id..mm;
select info from qmes_opta_info where group_nr = 0 order by info_nr;
spool off;
set termout on;

prompt Creating file q-&c_scheduling_id..txt...
set termout off;
spool ./q-&c_scheduling_id..txt;
select info from qmes_opta_info where group_nr = 1 order by info_nr;
prompt q-&c_scheduling_id..mm
select info from qmes_opta_info where group_nr = 2 order by info_nr;

spool off;
set termout on;

prompt Done.
