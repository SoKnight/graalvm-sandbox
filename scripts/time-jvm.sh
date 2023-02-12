#!/bin/bash

script_dir=$(dirname "$0")
cd "$script_dir/../" || exit 1

nik_home=/opt/java/liberica-nik/java17-22.3.1
export JAVA_HOME=$nik_home

command="$JAVA_HOME/bin/java -p target/gvmsandbox.jar -m graalvm.sandbox/me.soknight.graalvm.sandbox.Main"

/usr/bin/time -f "\nStart-up Time:\t%S sec." $command