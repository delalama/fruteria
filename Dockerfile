FROM openjdk:8-jdk-alpine
MAINTAINER elaltas
COPY target/asaiDemo-0.0.1-SNAPSHOT.jar fruitshop-1.0.0.jar
ENTRYPOINT ["java","-jar","/asaiDemo-0.0.1-SNAPSHOT.jar"]