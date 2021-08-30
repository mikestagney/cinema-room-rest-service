# Cinema Room Rest Service
REST controller with Java and Spring Boot to manage ticket sales for a movie theater.  Handles HTTP requests for available seats and allows users to purchase and return tickets. With the correct password, sales statistics are returned.

## Things learned 

How to customize exceptions to HTTP requests

How to customize the JSON responses by creating Java classes

Review of using the Spring Boot framework as a REST controller 

### Details

The movie theater has 81 seats, divided into 9 rows and 9 columns. Ticket prices are $10 for seats in the first four rows and $8 for the last five rows.

#### The cinema directory contains 8 files: 

* Main.java - sets up Spring Boot application framework 
* CinemaController.java - REST controller that receives and sends HTTP requests
* Auditorium.java - class with the fields and methods for the business model for the movie theater
* MovieSeat.java - class with the row, column and price of the individual seat
* Ticket.java - class that holds a ticket purchase object, which contains a MovieSeat object along with a random UUID number as a token
* Token.java - object for ticket return requests, allow Spring Boot to deserialize the JSON 
* ReturnedTicket.java - object to create JSON for ticket return responses
* Stats.java - class that holds sales information: the total income and number of seats available and seats sold

Eighteenth project created for JetBrains Academy Java Developer course - hard level project.

### How to Run

### Sample input and output:

All input and output are HTTP requests (screen shots to come)
