#!/bin/bash
docker-compose down
cp SiemaApp/SiemaApp-ear/target/SiemaApp-ear-1.0-SNAPSHOT/SiemaApp-web-1.0-SNAPSHOT.war Payara/
docker rmi payarafullapi
docker-compose up
