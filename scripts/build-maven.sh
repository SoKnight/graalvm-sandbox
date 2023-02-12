#!/bin/bash

script_dir=$(dirname "$0")
cd "$script_dir/../" || exit 1

nik_home=/opt/java/liberica-nik/java17-22.3.1
export JAVA_HOME=$nik_home

mvn clean package