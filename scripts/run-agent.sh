#!/bin/bash

script_dir=$(dirname "$0")
cd "$script_dir/../" || exit 1

nik_home=/opt/java/liberica-nik/java17-22.3.1
export JAVA_HOME=$nik_home

"$JAVA_HOME"/bin/java \
    -agentlib:native-image-agent=config-output-dir=src/main/resources/META-INF/native-image/ \
    -p target/classes/ \
    -m graalvm.sandbox/me.soknight.graalvm.sandbox.Main

bash "$script_dir/build-maven.sh"