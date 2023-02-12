@echo off

pushd %~dp0
set script_dir=%CD%

set nik_home=C:\Program Files\Java\Liberica-NIK\Java17-22.3.1
SET JAVA_HOME="%nik_home%"

cd ..\..\

%JAVA_HOME%\bin\native-image.cmd ^
    -H:Name=gvmsandbox ^
    -H:Path=target\native\ ^
    -H:ResourceConfigurationFiles=reachable-metadata\additional-resources.json ^
    -p target\gvmsandbox.jar ^
    -m graalvm.sandbox/me.soknight.graalvm.sandbox.Main