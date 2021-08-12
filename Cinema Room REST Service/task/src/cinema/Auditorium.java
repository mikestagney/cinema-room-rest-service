package cinema;

import java.util.ArrayList;
import java.util.List;

public class Auditorium {

    private final int total_rows = 9;
    private final int total_columns = 9;
    List<MovieSeat> available_seats = new ArrayList<>();

    Auditorium() {
        for (int row = 1; row <= total_rows; row++) {
            for (int col = 1; col <= total_columns; col++) {
                MovieSeat currentSeat = new MovieSeat(row, col);
                available_seats.add(currentSeat);
            }
        }
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public List<MovieSeat> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<MovieSeat> available_seats) {
        this.available_seats = available_seats;
    }
}
