#!/bin/bash
docker-compose down
cp SiemaApp/SiemaApp-ear/target/SiemaApp-ear-1.0-SNAPSHOT.ear Payara/
docker rmi payarafullapi
docker-compose up
