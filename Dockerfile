FROM maven:3.8.5-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
EXPOSE 8082

ARG HOST_RH=http://localhost:8080/rh/api
ARG SPRING_PROFILES_ACTIVE=dev

ENTRYPOINT java -jar app.jar