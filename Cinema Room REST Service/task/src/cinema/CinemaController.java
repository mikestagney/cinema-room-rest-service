package cinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CinemaController {

    private final int NUM_ROWS = 9;
    private final int NUM_COLUMNS = 9;
    List<MovieSeat> seatList = new ArrayList<>();

    CinemaController() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLUMNS; col++) {
                MovieSeat currentSeat = new MovieSeat(row + 1, col + 1);
                seatList.add(currentSeat);
            }
        }
    }


    @GetMapping("/seats")
    public List<MovieSeat> getAvailableSeats() {

        return seatList;


    }





}
