# Students API

This API allows the management of students, where each student has an ID, name, enrollment and course.

<br>

### To use the API, follow the steps below:

<hr>

1. Clone the repository on your machine:

```
git clone https://github.com/seu-usuario api-estudantes.git
```
2. Import the project into your preferred IDE (eg Eclipse, IntelliJ) as a Maven project.

3. Run the project as a Spring Boot application.

4. Access Swagger-UI at the following address: http://localhost:8080/swagger-ui/index.html#/

5. You will be able to see and test all operations available in the API, such as creating, updating, restoring and deleting a student.

6. Use the Student object to send API requests. The Student object has the following attributes:

- name (String): Name of the student.
- registration (String): Student registration.
- course (String): Student's course.

7. When sending a request, the API will return a Student object with the automatically generated ID.

## Examples

<hr>

### Create a student

<br>

To create a student, send a POST request to the "/students" endpoint with the Student object in the body of the request.

Student object example:

```
{
  "name": "João",
  "registration": "123456789",
  "course": "Software Engineering"
}
```

### Update a student

<br>

To update a student, send a PUT request to the "/students/{id}" endpoint with the updated Student object in the request body and the student ID in the URL.

Updated Student object example:

```
{
  "name": "João da Silva",
  "registration": "987654321",
  "course": "Computer Science"
}
```

### Recover a student
To retrieve a student, send a GET request to the "/students/{id}" endpoint with the student ID in the URL.

### Delete a student
To delete a student, send a DELETE request to the "/students/{id}" endpoint with the student ID in the URL.

## Conclusion
This is a simple API for student management that uses Spring Boot and can be tested through Swagger-UI. Feel free to use it and adapt it to your needs.