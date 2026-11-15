@echo off
setlocal
cd /d "%~dp0"
call mvnw.cmd -Pfast-dev -DskipTests package
endlocal