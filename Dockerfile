#
# Build stage
#
FROM maven:3.9.2-jdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -DskipTests -f /home/app/pom.xml clean package

#
# Package stage
#
# FROM arm64v8/openjdk:17-jdk
FROM openjdk:17-jdk
COPY --from=build /home/app/target/springboot-0.0.1-SNAPSHOT.jar /usr/local/lib/springboot-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/springboot-0.0.1-SNAPSHOT.jar"]