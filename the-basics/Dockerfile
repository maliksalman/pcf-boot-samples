FROM openjdk:8-jdk-alpine
ADD target/the-basics-1.0-SNAPSHOT.jar boot-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","boot-app.jar"]
