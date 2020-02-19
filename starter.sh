#!/usr/bin/bash
echo 'adfadsf';
#while ! (nc -z mysql-server 3308); do sleep 3; echo 'Waiting for mysql to start-up...'; done
echo "adfadsf"
#RUN apk add curl
#RUN apk add --update --no-cache netcat-openbsd
#COPY src ./src/
#COPY pom.xml ./pom.xml
#RUN mvn -f pom.xml clean package
#COPY ./target/conference-0.0.1-SNAPSHOT.jar conference-0.0.1-SNAPSHOT.jar
#java -jar /target/conference-0.0.1-SNAPSHOT.jar --spring.config.location=classpath:/application.properties


#while ! (nc -zv myssql-server 3308); do sleep 3; echo 'Waiting for config-server and eureka-server and rabbitmq to start-up...'; done
#java -jar --spring.config.location=classpath:/application.properties -Dspring.cloud.config.uri=http://config-server:8888 conference-0.0.1-SNAPSHOT.jar
##java -jar conference-0.0.1-SNAPSHOT.jar

#FROM maven:3.6.0-jdk-11-slim AS build

while ! nc -z mysql-server 3306 ; do
    echo "Waiting for upcoming Mysql Server"
    sleep 2
done

echo "result"

#java -jar conference-0.0.1-SNAPSHOT.jar --spring.config.location=classpath:/application.properties
java -jar ./conference-0.0.1-SNAPSHOT.jar --spring.config.location=classpath:/application.properties


#RUN apk add curl
#RUN apk add --update --no-cache netcat-openbsd
#COPY src ./src/
#COPY pom.xml ./pom.xml
#RUN mvn -f pom.xml clean package
#COPY ./target/conference-0.0.1-SNAPSHOT.jar conference-0.0.1-SNAPSHOT.jar
#java -jar /target/conference-0.0.1-SNAPSHOT.jar --spring.config.location=classpath:/application.properties
#mvn clean spring-boot:run

#
##RUN apk add curl
##RUN apk add --update --no-cache netcat-openbsd
##COPY src ./src/
##COPY pom.xml ./pom.xml
##RUN mvn -f pom.xml clean package
##COPY ./target/conference-0.0.1-SNAPSHOT.jar conference-0.0.1-SNAPSHOT.jar
##java -jar /target/conference-0.0.1-SNAPSHOT.jar --spring.config.location=classpath:/application.properties
#mvn clean spring-boot:run