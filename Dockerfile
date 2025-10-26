# Imagem oficial com Java 21 e Maven
FROM maven:3.9.2-eclipse-temurin-21

# Criar diretório de trabalho
WORKDIR /app

# Copiar pom.xml primeiro (para cache do Maven)
COPY pom.xml .

# Baixar dependências
RUN mvn dependency:go-offline

# Copiar todo o código fonte
COPY src ./src

# Build do projeto
RUN mvn clean package -DskipTests

# Executar a aplicação
ENTRYPOINT ["java","-jar","target/CondNotify-0.0.1-SNAPSHOT.jar"]

