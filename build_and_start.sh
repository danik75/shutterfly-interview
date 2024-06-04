#!/bin/bash
mvn clean install
docker build -t book-api .
docker-compose up