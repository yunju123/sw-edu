FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY target/spring-cloud-*.jar spring-cloud-workshop.jar
ENTRYPOINT exec java $JAVA_OPTS -jar spring-cloud-workshop.jar