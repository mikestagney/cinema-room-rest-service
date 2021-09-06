
# Cinema Room Rest Service
REST controller with Java and Spring Boot to manage ticket sales for a movie theater.  Handles HTTP requests for available seats and allows users to purchase and return tickets. With the correct password, sales statistics are returned. All output is HTTP responses.

## Things learned 

How to customize exceptions to HTTP requests

How to customize the JSON responses by creating Java classes

Review of using the Spring Boot framework as a REST controller 

### Details

The movie theater has 81 seats, divided into 9 rows and 9 columns. Ticket prices are $10 for seats in the first four rows and $8 for the last five rows.

#### The cinema directory contains 8 files: 

* Main.java - launches the Spring Boot application 
* CinemaController.java - REST controller that receives and sends HTTP messages
* Auditorium.java - business model with the fields and methods to manage movie theater ticket sales
* MovieSeat.java - object with the row, column and price of the individual seat
* Ticket.java - object which contains a MovieSeat object along with a random UUID number as a token
* Token.java - object for ticket return requests, allowing Spring Boot to deserialize the JSON for ticket returns
* ReturnedTicket.java - object serialized as a JSON for ticket return responses
* Stats.java - object that holds the total income and number of seats available and seats sold, serialized and returned as JSON

Eighteenth project created for JetBrains Academy Java Backend Developer course - hard level project.

### How to Run

To get a JSON of all the available seats, send a GET request to the /seats endpoint.

To purchase a ticket, send a POST request to the /purchase endpoint with a JSON in the response body containing row and column numbers.

To refund a purchased ticket, send a POST request to the /return endpoint with the token in the response body in JSON format.

To get sales information, send a POST request to the /stats endpoint with the password in the query parameters.

## Sample input and output: All HTTP requests and responses

Get a listing of all available seats

<img width="1108" alt="Get seats - all seats available" src="https://user-images.githubusercontent.com/49824414/132113927-70a5df16-2fec-44a2-9432-76b0639c184d.png">

Purchase a ticket

<img width="1131" alt="Purchase ticket - successful" src="https://user-images.githubusercontent.com/49824414/132114007-1bfcce4d-28b9-4636-a066-78239145f14c.png">

Get the listing of seats with one seat sold

<img width="1145" alt="Get seats - one seat sold" src="https://user-images.githubusercontent.com/49824414/132257951-af72a2eb-38fb-4079-be9c-15822db9ae2a.png">

Try to purchase seat that is already sold 

<img width="1130" alt="Purchase ticket - already bought" src="https://user-images.githubusercontent.com/49824414/132258168-ca4ec739-bf4f-4e89-a4a9-b803995dc2c3.png">

Try to purchase a seat that doesn't exist - only 9 seats in a row, not 15

<img width="1122" alt="Purchase ticket - column out of bounds" src="https://user-images.githubusercontent.com/49824414/132258254-cf364b81-1046-445a-b709-3fe8d3c2c64b.png">

Try to return ticket with a wrong token

<img width="1146" alt="Return ticket - wrong token" src="https://user-images.githubusercontent.com/49824414/132258327-b2225020-a66d-48f3-a3a1-ce0a8aa25097.png">

Return a ticket with the correct token

<img width="1128" alt="Return ticket - correct token" src="https://user-images.githubusercontent.com/49824414/132258365-a2d27bdd-8890-4637-8773-e7d58d796f81.png">

Try to get statistics with an incorrect password

<img width="1129" alt="Stats request - wrong password" src="https://user-images.githubusercontent.com/49824414/132258958-cad44c7e-171e-4bab-847b-8c1850f3f66d.png">

Get statistics with the correct password

<img width="1151" alt="Stats request - correct password" src="https://user-images.githubusercontent.com/49824414/132258982-10b84e81-100c-4c90-9225-13c2b97b3364.png">

