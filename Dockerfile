FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
EXPOSE 8080
COPY target/openapi-entities-mapping-1.0.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]