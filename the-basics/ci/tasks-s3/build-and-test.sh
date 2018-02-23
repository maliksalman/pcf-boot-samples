#!/bin/bash -ex

mvn -f the-basics-repo/the-basics/pom.xml package

version=$(cat version/version)
cp the-basics-repo/the-basics/target/*.jar the-basics-output/the-basics-${version}.jar
cp the-basics-repo/the-basics/manifest.yml the-basics-output/manifest-${version}.yml
