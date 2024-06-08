FROM eclipse-temurin:21-ubi9-minimal

ARG JAR_FILE
ARG DATASOURCE_URL
ARG DATASOURCE_USERNAME
ARG DATASOURCE_PASSWORD

RUN groupadd -r bluetrip && useradd -r -g bluetrip -d /app -s /sbin/nologin bluetrip

WORKDIR /app

COPY ${JAR_FILE} /app/app.jar

RUN chown -R bluetrip:bluetrip /app

ENV DATASOURCE_URL=${DATASOURCE_URL}
ENV DATASOURCE_USERNAME=${DATASOURCE_USERNAME}
ENV DATASOURCE_PASSWORD=${DATASOURCE_PASSWORD}

EXPOSE 8080

USER bluetrip

ENTRYPOINT ["java", "-jar", "app.jar"]