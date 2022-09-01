# technical-task Project

This project has been implemented as part of the interview process at CGM for the Backend Tech Lead position.
This project uses Quarkus, the Supersonic Subatomic Java Framework.

## Tech Stack Used
* Java version openjdk 16.0.2
* Quarkus Framework
* PostgreSQL v14
* Hibernate
* OpenAPI
* Swagger
* JUnit

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Implemented endpoints

### Get all patients
```json
GET /patient

Response
200 OK
[{
  "id": 0,
  "name": "string",
  "surname": "string",
  "dateOfBirth": "string",
  "socialSecurityNumber": "string"
}]
```

### Get a patient by id

```json
GET /patient/{id}

Response
200 OK
{
  "id": 0,
  "name": "string",
  "surname": "string",
  "dateOfBirth": "string",
  "socialSecurityNumber": "string"
}
```

### Saves a patient visit

```json
POST /patient/{id}/visit

Request body
{
  "date": "string",
  "time": "string",
  "type": "HOME",
  "reason": "FIRST_VISIT",
  "familyHistory": "string"
}

Response
201 Created

```

## TODO

* Endpoint to view/edit visits.
* Unit testing for the PatientService.
* Integration testing.
* Dockerisation.

## Swagger documentation

Swagger documentation is available local when running the project at
```
http://localhost:8080/q/swagger-ui/#/
```
