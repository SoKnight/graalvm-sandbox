#!/bin/bash

script_dir=$(dirname "$0")
cd "$script_dir/../" || exit 1

command="./target/gvmsandbox"

/usr/bin/time -f "\nStart-up Time:\t%S sec." $command