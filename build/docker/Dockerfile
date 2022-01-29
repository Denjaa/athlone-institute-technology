FROM openjdk:11
ARG JAR_FILE
RUN pwd
ECHO ${JAR_FILE}
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]