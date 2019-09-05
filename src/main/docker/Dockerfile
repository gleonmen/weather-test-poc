FROM openjdk:8-jdk-alpine

RUN apk update && \
    apk upgrade && \
    apk --no-cache add netcat-openbsd && \
    apk --no-cache add curl

RUN addgroup -S spring && \
    adduser -S -G spring spring

ADD run.sh run.sh
RUN chown spring run.sh
RUN chmod +x run.sh

USER spring

ADD central-weather-api*.jar /usr/local/central-weather-api.jar
CMD ./run.sh
