#!/bin/bash

cd the-basics-repo/the-basics
mvn package

cd ../..
mkdir -p the-basics-output/target
cp the-basics-repo/the-basics/target/*.jar the-basics-output/target/
cp the-basics-repo/the-basics/manifest.yml the-basics-output/

find /tmp/
