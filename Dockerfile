FROM openjdk:11
ARG JAR_FILE
RUN pwd
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]