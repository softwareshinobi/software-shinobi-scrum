#!/bin/bash

##

set -x

set -e

## 

cd ../../

source ./docker-image-repository.conf

##



set +x
set +e

docker stop $repositoryName
docker rm $repositoryName


set -x

set -e

docker-compose down

docker-compose stop

docker-compose pull

docker-compose up -d
