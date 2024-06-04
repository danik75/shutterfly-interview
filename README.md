# shutterfly
Some useful instruction on how to run the application against a postgres instance.

# Build project
Please run **_mvn clean install_**

# Containerization
From root project directory
**_docker build -t book-api ._**
verify image was created by running:
**_docker image ls_**
run
**_docker run -p 8080:8080 book-api_**

# Start postgres and application using docker-compose (requires docker installation on the machine)
To start postgres db and application, please use the docker compose in the project rood directory.
Via commandline, go to the root directory subdirectory and run command **_docker-compose up_**

# Start the Spring boot application - as stand-alone application
Please change directory to the root project dir and run the maven script:
**_./mvnw spring-boot:run_**  

# Full installation sequence
1. Build project as specified in **_Build project_** section
2. Create docker image as specified in the _**Containerization**_
3. Start application and DB as specified in - **_Start postgres and application using docker-compose_**




# Testing
To simplify, there is a postman collection inside the repo located at:
**_/shutterfly-interview/postman_**








