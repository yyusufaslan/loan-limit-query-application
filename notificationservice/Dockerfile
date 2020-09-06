FROM openjdk:8-jdk-alpine
ADD ./target/notificationservice-0.0.1-SNAPSHOT.jar /usr/src/notificationservice-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
VOLUME /tmp
EXPOSE 8081
ENTRYPOINT ["java","-jar", "notificationservice-0.0.1-SNAPSHOT.jar"]
