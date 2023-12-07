# AgencifyAssessment
Agencify Internship Interview Test

This is a fullstack Project that was testing understanding on the following. 

**Java and Spring Boot:**
1.	Spring Boot Basics:
      Understanding of the Spring Boot framework for building Java-based web applications.
      Knowledge of annotations such as @RestController, @Service, and @Autowired.
2.	RESTful Web Services:
      Implementation of RESTful web services using Spring Boot controllers.
      Handling HTTP requests (GET, POST) for CRUD operations.
3.	Spring Data JPA:
      Integration with Spring Data JPA for database interactions.
      Configuration of JPA entities, repositories, and usage of methods like findAll and custom query methods.
4.	Exception Handling:
      Handling exceptions in Spring Boot applications.
      Returning appropriate HTTP status codes and error messages.
  	
Databases:
1. Validation
    Integration with a database using Spring Data JPA repositories.
    Knowledge of entity modeling for database tables.

 Regular Expressions (REGEX):
1. Validation
     Use of regular expressions for phone number validation in the PhoneNumberService.
     Applying different REGEX patterns for various countries.

 Angular:
1. Angular Basics:
     Understanding of Angular components, services, and templates.
     Usage of Angular decorators such as @Component, @Inject, and @Output.

2. HTTP client:
     Integration with an HTTP client in Angular to communicate with the Spring Boot backend.
     Usage of services to encapsulate backend interactions.

3. User Interface:
     Implementation of a simple user interface for adding phone numbers in Angular.
     Handling form submissions and displaying response messages.

 General Web Developement:

 1. Client-Server Interaction:
      Understanding the interaction between the frontend (Angular) and the backend (Spring Boot) in a client-server architecture.
 2. Testing
      Implementation of tests for both the backend (using JUnit) and the frontend (using Angular testing utilities).
    

The project appears to assess a candidate's ability to develop a full-stack application, involving backend development with Spring Boot, frontend development with Angular, and integration with a database. Additionally, the inclusion of phone number validation using regular expressions demonstrates knowledge of input validation and data integrity.

Understanding how these technologies work together and solving challenges related to data validation and user interaction seems to be the focus of this project.

To run the Project:

```bash
git clone https://github.com/titus-360/AgencifyAssessment.git

```

Navigate to the project Repository: 

```
cd Test
```
Running the Backend (Spring Boot)
Using Graddlle:

Run the following Gradle Command to build and run the Spring Boot application:

```
$ ./gradlew run

```
```
$ ./gradlew build

```
The backend will be accessible at http://localhost:8080

Running the Frontend (Angular):

1. Navigate to the `frontend` directory:

```
cd ./frontend/AgencifyTask
```
2. Install Dependencies:

```
npm install

```
3. Run the angular application:

```
ng serve
```

The frontend will be accessible at http://localhost:4200.

Testing:
To run the backend tests, use the following command:

```
./gradlew TestApplicationTests
```
Database
Database Choice

Initially, the project was intended to use SQLite 3 as the preferred database. However, due to challenges with Docker installation, I opted to use MySQL for testing purposes.

Database Configuration

Database Name: agencify

**Challenges Faced**

I encountered issues with Docker installation, which affected the planned use of SQLite 3. To keep the project moving forward, I decided to use MySQL as an alternative for testing purposes.


_**Frontend REGEX Validation Results:**_

1. The image below shows a screenshot of phone numbers that are displayed:
![PhoneNumberList](https://github.com/titus-360/AgencifyAssessment/assets/124245986/c7ab60ff-b499-4461-ad38-80d41091ff80)

2. The image below shows REGEX validation when an invalid country is entered:
![InvalidCountry](https://github.com/titus-360/AgencifyAssessment/assets/124245986/5e73828a-c49c-4edc-885a-5800d4488188)

3. The image below shows REEX validation when an invalid phone number is entered:
![InvalidPhoneNumber](https://github.com/titus-360/AgencifyAssessment/assets/124245986/7dab2dd0-a1cc-45e1-b850-0803bd03b67d)

4. The image below shows REGEX validation when correct phone number, country, state and country code are entered:
![ValidPhoneNumber](https://github.com/titus-360/AgencifyAssessment/assets/124245986/2fa922b6-a7a5-4046-9f99-ce8c3f9b6d24)







  
