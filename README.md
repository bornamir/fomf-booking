<!-- TOC -->
* [Introduction](#introduction)
* [Stack](#stack)
* [Installation](#installation)
  * [Cloning The Project](#cloning-the-project)
  * [Running The Project](#running-the-project)
    * [1. JVM](#1-jvm)
    * [2. Docker](#2-docker)
* [API Documentation](#api-documentation)
* [Considerations](#considerations)
<!-- TOC -->

# Introduction
This project is created during the process of a job interview for FomF platform. 
Details of the required task can be found here: `doc/Back-End Engineer Task.pdf`

# Stack
  * Java/openjdk 11
  * Kotlin 1.6
  * Spring Boot 2.7
  * Gradle 7.5
# Installation 
To install and run this project, please follow these steps:

  ## Cloning The Project
```shell
git clone https://github.com/bornamir/fomf-booking.git
# or with SSH
git clone git@github.com:bornamir/fomf-booking.git
```
## Running The Project
There is 2 options: running it with the jvm or docker
### 1. JVM
Make sure that jvm-11 is installed on the system. then from the root directory of the project run :
```shell
java -jar build/libs/booking-0.0.1-SNAPSHOT.jar
```
### 2. Docker
Make sure that docker is installed on the system. 
First build the image with the help of the `Dockerfile`. From the root directory of the project run:
```shell
docker build -t fomf-booking:1.0 . 
```
Then , run the image:
```shell
docker run -p 8000:8000 fomf-booking:1.0
```

If everything is fine, the project should be running on port 8000. 
By accessing [localhost:8000](http://localhost:8000) you should see a <bold>Hello </bold> message


# API Documentation
The API documentation can be found under [swagger-ui/index.html](http://localhost:8000/swagger-ui/index.html) address.

The document is generated automatically with the help of *springdoc-openapi* package. It uses OpenAPI Spec version 3. The schema can also be accessed [here](http://localhost:8000/api)


# Considerations
About the  implementation of this project, following items should be considered:
## validations
In the *Validity of Ticket* section of the document 5 criteria has been mentioned.
Based on the first one, DAY and HALF_DAY tickets which are on the same date are invalid. 
Second and Third criteria are invalidating ticket of type ENTIER_EVENT with any other type, regardless of the date.
So it means that in the scope of one specific day, there cannot be two tickets with different types. 
The only remaining situation is when there is two tickets with same date and same type. 
The document does not specifically mention anything about it, but considering the fact that this API is for booking 
tickets for an event by one person, it was assumed that tickets on the same date and with same type are not valid.
Following the same logic, the same decision was made for the participation type based on the forth criteria.
Hence, the validations simplified to the following:

        No two tickets with same date is allowed.

# Next Steps
## 1. Add Tests
Currently, no unit or integration tests are included in the project

## 2. Enhance API Document
Although currently all the end points and their general specs are recognized and displayed by swagger,
the schema can be improved to include more detailed information of each path.

