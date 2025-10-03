#!/bin/sh
MVNW_REPOURL="https://repo.maven.apache.org/maven2"
WRAPPER_JAR=".mvn/wrapper/maven-wrapper.jar"
if [ ! -f "$WRAPPER_JAR" ]; then
  echo "Maven wrapper jar missing. Please run 'mvn -N io.takari:maven:wrapper' to generate a proper wrapper or install Maven."
fi
exec mvn "$@"
