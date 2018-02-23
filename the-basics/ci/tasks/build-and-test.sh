#!/bin/bash

echo "Now Running in a script!!!"
mvn -f the-basics-repo/the-basics/pom.xml package
mkdir -p the-basics-output/target
cp the-basics-repo/the-basics/target/*.jar the-basics-output/target/
cp the-basics-repo/the-basics/manifest.yml the-basics-output/
