@echo off

pushd %~dp0
set script_dir=%CD%

set nik_home=C:\Program Files\Java\Liberica-NIK\Java17-22.3.1
SET JAVA_HOME="%nik_home%"

cd ..\..\
%JAVA_HOME%\bin\java.exe ^
    -agentlib:native-image-agent=config-output-dir=src\main\resources\META-INF\native-image\ ^
    -p target\classes\ ^
    -m graalvm.sandbox/me.soknight.graalvm.sandbox.Main

call %script_dir%\build-maven.bat