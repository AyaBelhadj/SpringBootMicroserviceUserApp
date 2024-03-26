FROM openjdk:21-jdk
WORKDIR /app
COPY /target/userApp-0.0.1-SNAPSHOT.jar /app/userApp.jar
EXPOSE 5000
CMD ["java", "-jar", "userApp.jar"]