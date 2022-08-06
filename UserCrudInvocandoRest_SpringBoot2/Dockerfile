FROM maven:3.6-jdk-8-alpine AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B package -Dmaven.test.skip=true

FROM openjdk:8-jre-alpine
COPY --from=builder /app/target/APIRest-Cliente.jar APIRest-Cliente.jar
CMD ["java", "-jar","APIRest-Cliente.jar"]
