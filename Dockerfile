FROM openjdk:11
ARG JAR_FILE
RUN pwd
COPY build/libs/${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]