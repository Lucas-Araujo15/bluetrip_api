FROM eclipse-temurin:21-ubi9-minimal

COPY ./build/libs/*.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]