FROM openjdk:8
EXPOSE 8081

ADD target/RestService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
