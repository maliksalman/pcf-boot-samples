#!/bin/bash

if [[ ! -z $local_mvnrepo_host ]]; then 
mkdir -p ~/.m2
cat >~/.m2/settings.xml <<EOL
<settings>
  <activeProfiles><activeProfile>artifactory</activeProfile></activeProfiles>
  <profiles>
    <profile>
      <id>artifactory</id>
      <repositories>
        <repository>
          <id>central</id>
          <name>libs-release</name>
          <url>http://${local_mvnrepo_host}:8081/artifactory/libs-release</url>
        </repository>
      </repositories>
      <pluginRepositories>
        <pluginRepository>
          <id>central</id>
          <name>plugins-release</name>
          <url>http://${local_mvnrepo_host}:8081/artifactory/plugins-release</url>
        </pluginRepository>
      </pluginRepositories>
    </profile>
  </profiles>
</settings>
EOL
fi
mvn -f the-basics-repo/the-basics/pom.xml package

version=$(cat version/version)
cp the-basics-repo/the-basics/target/*.jar the-basics-output/the-basics-${version}.jar
cp the-basics-repo/the-basics/manifest.yml the-basics-output/manifest-${version}.yml
