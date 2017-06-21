FROM openjdk:8-jdk-alpine
MAINTAINER aaron <aaron.long.c@gmail.com>
RUN apk update && apk upgrade
RUN apk add maven
RUN mkdir -p /usr/src/server
WORKDIR /usr/src/server