# shutterfly
Some useful instruction on how to run the application against a postgres instance.

# Start postgres using docker (requires docker installation on the machine)
To start postgres please use the docker compose in the shutterfly/docker folder.
Via commandline, go to the _shutterfly/docker_ subdirectory and run command _docker-compose up_

# Start the Spring boot application
Please change directory to the root project dir and run the maven script:
_./mvnw spring-boot:run_  

# Testing
To simplify, there is a postman collection inside the repo located at:
_/shutterfly/postman_

# Containerization
From root project directory
_docker build --build-arg JAR_FILE=target/*.jar -t book-api_
verify image was created by running:
_docker image ls_
run
_docker run book-api:latest_






