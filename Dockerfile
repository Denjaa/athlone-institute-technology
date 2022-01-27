FROM openjdk:11
ARG JAR_FILE
COPY ${JAR_FILE} app.jar

RUN addgroup -g 1001 -S appuser && adduser -u 1001 -S appuser -G appuser
RUN mkdir /opt && chown -R appuser:appuser /opt/mycompany
RUN mkdir /logs && chown -R appuser:appuser /logs
USER appuser

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

# ENTRYPOINT ["java", "-jar", "/app.jar"]