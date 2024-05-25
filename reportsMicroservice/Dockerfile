#FROM ubuntu:latest
#LABEL authors="maria"
#
#ENTRYPOINT ["top", "-b"]
#
FROM openjdk:21
COPY target/reportsMicroservice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8070
ENTRYPOINT ["java","-jar","app.jar"]