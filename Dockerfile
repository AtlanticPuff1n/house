FROM openjdk:11
LABEL maintainer="house"
ADD target/house-0.0.1-SNAPSHOT.jar house.jar
ENTRYPOINT ["java", "-jar", "house.jar"]