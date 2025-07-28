FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu as base

EXPOSE 8080

ADD target/bibliosoft-microservice.jar bibliosoft-microservice.jar

ENTRYPOINT ["java", "-jar", "bibliosoft-microservice.jar"]