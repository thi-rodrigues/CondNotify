# IMAGEM BASE
FROM ubuntu:latest AS build

# EXCUTAR DENTRO DO CONTAINER
RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . .

RUN apt-get install maven -y

RUN mvn clean install

FROM openjdk:21-jre-slim

EXPOSE 8080

COPY --from=build /target/CondNotify-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]