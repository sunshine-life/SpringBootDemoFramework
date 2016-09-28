#!/bin/ksh  
echo "--------helloWorld------->>"  
JAVA_HOME="/opt/Java/jdk/jdk1.8.0_101"  
JAVA_OPTIONS=" -hotspot -Xms128m -Xmx512m "    
rm -f tpid
nohup java -cp .:spring-boot-sample-mybatis-0.0.1-SNAPSHOT.jar  com.example.Application > /data/guanqian-8080/nohup.out 2>&1  &

