#!/bin/sh
APP_NAME=spring-boot-sample-mybatis-0.0.1-SNAPSHOT.jar

tpid=`ps -ef|grep $APP_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
if [ ${tpid} ]; then
        echo 'App is running.'
else
        echo 'App is NOT running.'
fi
