#!/usr/bin/env bash
export JAVA_OPTS="$JAVA_OPTS -Dtasks.service=http://localhost:80/tasks/"
/opt/tomcat/bin/catalina.sh run
