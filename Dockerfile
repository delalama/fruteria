FROM openjdk:11
MAINTAINER elaltas
COPY target/asaiDemo-0.0.1-SNAPSHOT.jar fruitshop-1.0.0.jar
ENTRYPOINT ["java","-jar","/fruitshop-1.0.0.jar"]
