package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
    public MovieSeat buyTicket(@RequestParam int row, @RequestParam int column) {

        if (row < 0 || row > auditorium.getTotal_rows() || column < 0 || column > auditorium.getTotal_columns()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The number of a row or column is out of bounds!");
        }

        MovieSeat seat = new MovieSeat(row, column);

        if (auditorium.isSeatPurchased(seat)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The ticket has been already purchased!");
        }

        auditorium.buySeat(seat);

        return seat;
    }


}
