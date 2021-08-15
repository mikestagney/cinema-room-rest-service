package cinema;

import java.util.*;

public class Auditorium {

    private final int total_rows = 9;
    private final int total_columns = 9;  //  Collections.synchronizedList(new ArrayList<>());
    Set<MovieSeat> available_seats = new LinkedHashSet<>();

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

    public Set<MovieSeat> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(Set<MovieSeat> available_seats) {
        this.available_seats = available_seats;
    }

    public boolean isSeatPurchased(MovieSeat seat) {


        //return !available_seats.contains(seat);

        // return !available_seats.contains(seat);
        for (MovieSeat currentSeat : available_seats) {
            if (currentSeat.equals(seat)) {
                return false;
            }
        }
        return true;


        /*
        synchronized (available_seats) {
            for (MovieSeat currentSeat : available_seats) {
                if (Objects.equals(currentSeat, seat)) {
                    return false;
                }
            }
            return true;
        }*/
    }
}
