Microservices in Java based on the course of Microservices and Distributed Systems by AmigosCode with a DDD architectural approach

How to run with Docker
---
```bash
docker compose up -d
```

## Add the email environment variables for the smtp server while running or in the application.properties file
```txt
-Dspring.mail.host=<host> -Dspring.mail.port=<port> -Dspring.mail.username=<Username> -Dspring.mail.password=<Password>
```