#!/bin/sh
echo "Hello world"

PROPERTY_FILE=dockerimage.properties

function getProperty {
   PROP_KEY=$1
   PROP_VALUE=`cat $PROPERTY_FILE | grep "$PROP_KEY" | cut -d'=' -f2`
   echo $PROP_VALUE
}

echo "# Reading property from $PROPERTY_FILE"
URL=$(getProperty "uri")
echo $URL
#docker login --username=ravisankar --password=Qwert123@
#echo "docker run -d -p 8085:8080 ravisankar/todowebapp"${URL}
docker run -d -p 8085:8080 --name currencyexchange ravisankar/currencyexchange${URL}