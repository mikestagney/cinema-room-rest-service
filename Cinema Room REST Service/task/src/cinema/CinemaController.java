package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CinemaController {

    Auditorium auditorium;// = new Auditorium();

    CinemaController() {
        auditorium = new Auditorium();
    }

    @GetMapping("/seats")
    public Auditorium getAvailableSeats() {

        return auditorium;
    }

    @PostMapping("/purchase")
    public MovieSeat buyTicket(@RequestBody MovieSeat seat) {
        /*
        @RequestParam int row, @RequestParam int column
        if (auditorium.allSeats.isEmpty()) {
            System.out.println("seat list has no values");
            auditorium = new Auditorium();
        }*/

        if (seat.getRow() < 1 || seat.getRow() > auditorium.getTotal_rows() || seat.getColumn() < 1 || seat.getColumn() > auditorium.getTotal_columns()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The number of a row or column is out of bounds!");
        }

        // add request body, not request parameters
        //MovieSeat newSeat = new MovieSeat(seat.getRow(), seat.getColumn());

        if (auditorium.isSeatPurchased(seat)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The ticket has been already purchased!");
        }

        auditorium.buySeat(seat);

        return seat;
    }


}
