# download maven image from Docker Hub
FROM maven:3-jdk-11-slim AS MVN_BUILD

# copy and packing source code in docker image
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn -DskipTests=true -B package --file pom.xml

# download openjdk image
FROM openjdk:11-jre-slim

# run jar file in docker container
WORKDIR /app
COPY --from=MVN_BUILD /build/target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]