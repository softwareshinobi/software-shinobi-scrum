#!/bin/bash

##

reset

clear

##

set -e

set -x

##

rm -rf target/

mvn install 

##

java -jar target/software-shinobi-scrum-1.0-SNAPSHOT.jar
