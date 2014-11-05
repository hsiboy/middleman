@echo off
SET ANT_HOME=%CD%\tools\apache-ant-1.8.3
SET ANT_OPTS=-Xmx1024m
CALL %ANT_HOME%\bin\ant -lib lib\build -lib lib/test %*
IF ERRORLEVEL 1 goto RedBuild
IF ERRORLEVEL 0 goto GreenBuild

:RedBuild
color 4f
type .\tools\buildflags\dos_failed.txt

goto TheEnd

:GreenBuild
color 2F
type .\tools\buildflags\dos_passed.txt

:TheEnd
pause

color 07

