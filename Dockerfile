FROM openjdk:8-jre
MAINTAINER Bruno Silva
ADD /target/sale-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT java -jar app.jar
