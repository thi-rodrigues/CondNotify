# Use imagem oficial do Java 21
FROM ubuntu:latest AS build

# Criar diretório de trabalho
WORKDIR /app

# EXCUTAR DENTRO DO CONTAINER
RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . .

RUN apt-get install maven -y

RUN mvn clean install

FROM openjdk:21-jdk-slim

# COPY --from=build /target/CondNotify-0.0.1-SNAPSHOT.jar app.jar
# Copiar o jar compilado do host para o container
COPY target/*.jar app.jar

# Expor porta da aplicação
EXPOSE 8080

# Comando de execução
ENTRYPOINT ["java", "-jar", "app.jar"]
