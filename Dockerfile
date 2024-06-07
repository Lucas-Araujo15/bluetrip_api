FROM eclipse-temurin:21-ubi9-minimal

ARG JAR_FILE

WORKDIR /app

COPY ${JAR_FILE} /app/app.jar

ENV DATASOURCE_URL=jdbc:oracle:thin:@//oracle.fiap.com.br:1521/orcl
ENV DATASOURCE_USERNAME=rm550841
ENV DATASOURCE_PASSWORD=091104

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]