#!/bin/sh

echo "********************************************************"
echo "Starting Weather Central API"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom  \
     -jar /usr/local/central-weather-api.jar
