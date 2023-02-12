#!/bin/bash

script_dir=$(dirname "$0")
cd "$script_dir/../" || exit 1

nik_home=/opt/java/liberica-nik/java17-22.3.1
export JAVA_HOME=$nik_home

"$JAVA_HOME"/bin/native-image \
    -H:Name=gvmsandbox \
    -H:Path=target/ \
    -H:IncludeResources=".*\\.otf" \
    -p target/gvmsandbox.jar \
    -m graalvm.sandbox/me.soknight.graalvm.sandbox.Main