# Cinema Room Rest Service
REST controller with Java and Spring Boot to manage ticket sales for a movie theater.  Handles HTTP requests for available seats and allows users to purchase and return tickets. With the correct password, sales statistics are returned. All output is HTTP responses.

## Things learned 

How to customize exceptions to HTTP requests

How to customize the JSON responses by creating Java classes

Review of using the Spring Boot framework as a REST controller 

### Details

The movie theater has 81 seats, divided into 9 rows and 9 columns. Ticket prices are $10 for seats in the first four rows and $8 for the last five rows.

#### The cinema directory contains 8 files: 

* Main.java - lauches the Spring Boot application 
* CinemaController.java - REST controller that receives and sends HTTP messages
* Auditorium.java - class with the fields and methods for the business model to manage the movie theater
* MovieSeat.java - object with the row, column and price of the individual seat
* Ticket.java - object which contains a MovieSeat object along with a random UUID number as a token
* Token.java - object for ticket return requests, allowing Spring Boot to deserialize the JSON for ticket returns
* ReturnedTicket.java - object to serialize to a JSON for ticket return responses
* Stats.java - object that holds the total income and number of seats available and seats sold

Eighteenth project created for JetBrains Academy Java Developer course - hard level project.

### How to Run

### Sample input and output:

All input and output is with HTTP requests and responses (screen shots to come)
