package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
            throw new TicketPurchaseError("The number of a row or a column is out of bounds!");
        }
        if (auditorium.isSeatPurchased(seat)) {
            throw new TicketPurchaseError("The ticket has been already purchased!");
        }
        return auditorium.buySeat(seat);
    }

    @PostMapping("/return")
    public ReturnedTicket returnTicket(@RequestBody Token token) throws AuthorizationError {
        if (!auditorium.isTokenValid(token)) {
            throw new TicketPurchaseError("Wrong token!");
        }
        return auditorium.returnTicket(token);
    }

    @PostMapping("/stats")
    public Stats returnStats(@RequestParam(required = false) String password) {
        if (password == null || !password.equals(auditorium.password)) {
            throw new AuthorizationError("The password is wrong!");
        }
        return auditorium.getCurrentStats();
    }
}

    class TicketPurchaseError extends RuntimeException {
        private String message;

        public TicketPurchaseError() {
        }

        public TicketPurchaseError(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
    class AuthorizationError extends RuntimeException {
        private String message;

        public AuthorizationError() {
        }
        public AuthorizationError(String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
    class ErrorResponse {

        private String error;

        public ErrorResponse() {
        }
        public ErrorResponse(String error) {
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

        @ExceptionHandler(TicketPurchaseError.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ResponseBody
        public ErrorResponse handlePurchaseException(TicketPurchaseError e) {
            return new ErrorResponse(e.getMessage());
        }

        @ExceptionHandler(AuthorizationError.class)
        @ResponseStatus(HttpStatus.UNAUTHORIZED)
        @ResponseBody
        public ResponseEntity<?> handleWrongLogin(AuthorizationError e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(errorResponse);
        }
}

