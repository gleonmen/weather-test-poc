#!/bin/sh
getPort() {
    echo $1 | cut -d : -f 3 | xargs basename
}



echo "********************************************************"
echo "Starting Weather Central API"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom  \
     -jar /usr/local/weather-api.jar
