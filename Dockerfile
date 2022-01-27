FROM openjdk:11
ARG JAR_FILE
COPY ${JAR_FILE} app.jar

USER appuser
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
# ENTRYPOINT ["java", "-jar", "/app.jar"]