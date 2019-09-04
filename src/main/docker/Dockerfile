FROM openjdk:8-jdk-alpine

RUN apk update && \
    apk upgrade && \
    apk --no-cache add netcat-openbsd && \
    apk --no-cache add curl

RUN cd /tmp/ && \
    curl -k -LO "http://download.oracle.com/otn-pub/java/jce/8/jce_policy-8.zip" -H 'Cookie: oraclelicense=accept-securebackup-cookie' && \
    unzip jce_policy-8.zip && \
    rm jce_policy-8.zip && \
    yes |cp -v /tmp/UnlimitedJCEPolicyJDK8/*.jar /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/


RUN addgroup -S spring && \
    adduser -S -G spring spring

ADD run.sh run.sh
RUN chown spring run.sh
RUN chmod +x run.sh

USER spring

ADD central-weather-api*.jar /usr/local/
CMD ./run.sh
