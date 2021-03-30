# README

# Install Docker for Desktop

## Starting DEV environment

- Elastisearch 7.10.1
- Kibana 7.10.1
- Postgres 12

> Starting

```shell
$ docker-compose up -d
```

> Stopping

```shell
$ docker-compose down
```

# Start spring boot app

- mvn spring-boot:run in the project root folder

# REST Client 
Open a Rest Client of your choice (Postman/Postwoman/ etc)

# OpenAPI doc 
Check openapi documentation for the wimm service endpoints. http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

# Data preparation
Send to the 
​/api​/transactions endpoint request using JSON objects from the data/json/JSON_file.json 

# Visualize data in Kibana
open Dashboard - Wimm dashboard in Kibana and visualize data

