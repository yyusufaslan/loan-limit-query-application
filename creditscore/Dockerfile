FROM java:8
VOLUME /tmp
ADD target/creditscore-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/creditscore", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

