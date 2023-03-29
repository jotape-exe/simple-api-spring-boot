# Spring Boot API Usage Guide for Recording Student Enrollments

This document provides instructions on how to use the Spring Boot API to register student enrollments in courses and courses. The API was developed with Java and uses the MySQL database. Additionally, the API has documentation for the Swagger-ui interface, which can be used to test endpoints.

## Configuration

Before you begin, make sure you have MySQL installed and configured correctly. Then, create a database in MySQL and update the `application.properties` file settings with the database access information, as shown in the example below:

```
#Database Config
spring.datasource.url=jdbc:mysql://localhost:3306/<DB_NAME>?createDatabaseIfNotExist=true
spring.datasource.username=<MYSQL_USERNAME>
spring.datasource.password=<MYSQL_PASSWORD>
```

Replace <DB_NAME>, <DB_USERNAME> and <DB_PASSWORD> with the correct information.

## Testing the endpoints

After running the application, go to 
```
http://localhost:8080/swagger-ui/index.html#/ 
```
and voilá! You will have access to Swagger with the fully documented api. From Schemas to the endpoints of each controller, Swagger does it without you having to use a web client.