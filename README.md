Microservices in Java based on the course of Microservices and Distributed Systems by AmigosCode with a DDD architectural approach

This project shows an example of a Client registration endpoint that comunnicates between different microservices. Once we call the endpoint we make a call to a Fraud microservice that queries the database and checks if a user is a fraud or not. In the case where a user is valid, it then uses a Kafka Queue to insert the notification message of the new user. The Notification microservice consumes this queue and sends an Email to the end client.

To help monitor these services, we use a few different tools. For response timings and tracing we use Zipkin which collects data from all our microservices. For logging we use the ELK stack (ElastiSearch, Logstash and Kibana).

To manage the microservices we use Netflix's Eureka Server. Alongside this we also use the Spring API Gateway as an entrypoint to our Customer endpoint.

## How to run with Docker
---
```bash
docker compose up -d
```

## How to build the project locally and push to dockerhub
---
```bash
mvn clean package -P build-docker-image
```

## Add the email environment variables for the smtp server while running or in the application.properties file
```txt
-Dspring.mail.host=<host> -Dspring.mail.port=<port> -Dspring.mail.username=<Username> -Dspring.mail.password=<Password>
```
