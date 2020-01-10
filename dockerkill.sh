#!/bin/bash
echo "Hello world"

docker kill currencyexchange

if [ $? == 0 ]; then
    docker rm currencyexchange
fi

if [ $? == 0 ]; then
    echo "removed"
else
    echo "image not found"
fi
