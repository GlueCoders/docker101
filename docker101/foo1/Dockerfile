FROM maven:3.6-jdk-8 AS build
COPY src /usr/app/src
COPY pom.xml /usr/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:8-jdk-alpine
COPY --from=build /usr/app/target/foo1-1.0.0-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]