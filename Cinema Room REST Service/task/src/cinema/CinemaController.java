package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaController {

    Auditorium auditorium;

    CinemaController() {
        auditorium = new Auditorium();
    }

    @GetMapping("/seats")
    public Auditorium getAvailableSeats() {
        return auditorium;
    }
    @PostMapping("/purchase")
    public Ticket buyTicket(@RequestBody MovieSeat seat) {
        if (seat.getRow() < 1 || seat.getRow() > auditorium.getTotal_rows() || seat.getColumn() < 1 || seat.getColumn() > auditorium.getTotal_columns()) {
            throw new ticketPurchaseError("The number of a row or a column is out of bounds!");
        }
        if (auditorium.isSeatPurchased(seat)) {
            throw new ticketPurchaseError("The ticket has been already purchased!");
        }
        return auditorium.buySeat(seat);
    }
    @PostMapping("/return")
     public ReturnedTicket returnTicket(@RequestBody Token token) {
        if (!auditorium.isTokenValid(token)) {
            throw new ticketPurchaseError("Wrong token!");
        }
        return auditorium.returnTicket(token);
    }
}

    class ticketPurchaseError extends RuntimeException{
        private String message;

        public ticketPurchaseError() {
        }

        public ticketPurchaseError(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
    class PurchaseErrorResponse {

        private String error;

        public PurchaseErrorResponse() {
        }
        public PurchaseErrorResponse(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
    @ControllerAdvice
    class CinemaControllerAdvice {

    @ExceptionHandler(ticketPurchaseError.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public PurchaseErrorResponse handlePurchaseException(ticketPurchaseError e) {
        return new PurchaseErrorResponse(e.getMessage());
    }
}


