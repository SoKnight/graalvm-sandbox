@echo off

pushd %~dp0
set script_dir=%CD%

set nik_home=C:\Program Files\Java\Liberica-NIK\Java17-22.3.1
SET JAVA_HOME=%nik_home%

cd ..\..\
mvn clean package