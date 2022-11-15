#!/usr/bin/env bash

export JAVA_HOME=/home/tiago/jdk-17.0.3.1
export PATH=$JAVA_HOME/bin:$PATH
mvn spring-boot:run -Dspring-boot.run.profiles=dev
