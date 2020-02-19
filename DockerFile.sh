#!/usr/bin/env bash
# base image
#FROM node:9.6.1
#FROM java:8
#FROM maven:3.5-jdk-8-alpine
#MAINTAINER Brian Hannaway
#COPY pom.xml /build/
#COPY src /build/src/
#WORKDIR /build/
#RUN mvn clean package -DskipTests
#WORKDIR /app
#COPY  /build/target/conference-0.0.1-SNAPSHOT.jar /app/
#COPY ./starter.sh starter.sh
##CMD ["java","-jar",".conference-0.0.1-SNAPSHOT.jar"]
#RUN apk add curl
#RUN apk add --update --no-cache netcat-openbsd
#
#EXPOSE 8080
#RUN ["chmod", "+x", "starter.sh"]
#ENTRYPOINT ["sh","starter.sh"]

FROM node:9.6.1

# our base build image
FROM maven:3.5-jdk-8 as maven

# copy the project files
COPY ./pom.xml ./pom.xml

# build all dependencies
RUN mvn dependency:go-offline -B

# copy your other files
COPY ./src ./src

# build for release
RUN mvn package -DskipTests

# our final base image
FROM openjdk:8u171-jre-alpine

# set deployment directory
WORKDIR /my-project

# copy over the built artifact from the maven image
COPY --from=maven target/conference-0.0.1-SNAPSHOT.jar ./

COPY ./starter.sh starter.sh
#CMD ["java","-jar",".conference-0.0.1-SNAPSHOT.jar"]
RUN apk add curl
RUN apk add --update --no-cache netcat-openbsd

EXPOSE 8080
RUN ["chmod", "+x", "starter.sh"]
ENTRYPOINT ["sh","starter.sh"]

# set the startup command to run your binary

