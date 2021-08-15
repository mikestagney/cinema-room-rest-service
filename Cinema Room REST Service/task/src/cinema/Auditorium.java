package cinema;

import java.util.*;

public class Auditorium {

    private final int total_rows = 9;
    private final int total_columns = 9;  //  Collections.synchronizedList(new ArrayList<>());
    List<MovieSeat> available_seats;
    private List<MovieSeat> allSeats = new ArrayList<>();


    Auditorium() {
        for (int row = 1; row <= total_rows; row++) {
            for (int col = 1; col <= total_columns; col++) {
                MovieSeat currentSeat = new MovieSeat(row, col);
                //available_seats.add(currentSeat);
                allSeats.add(currentSeat);
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
        available_seats = new ArrayList<>();
        for (MovieSeat seat : allSeats) {
            if (!seat.isPurchased()) {
                available_seats.add(seat);
            }
         }
        return available_seats;
    }

    public void setAvailable_seats(List<MovieSeat> available_seats) {
        this.available_seats = available_seats;
    }
    public int getSeat(int row, int col) {
        return col + ((row - 1) * 10) - row;
    }


    public boolean isSeatPurchased(MovieSeat seat) {
        int index = getSeat(seat.getRow(), seat.getColumn());
        MovieSeat currentSeat = available_seats.get(index);

        return currentSeat.isPurchased();
        // return !available_seats.contains(seat);
               /*
        for (MovieSeat currentSeat : available_seats) {
            if (currentSeat.equals(seat)) {
                System.out.println("this is it");
                return false;
            }
        }
        System.out.println("something isn't working");
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
    public void buySeat(MovieSeat seat) {
        int index = getSeat(seat.getRow(), seat.getColumn());
        MovieSeat boughtSeat = available_seats.remove(index);
        boughtSeat.setPurchased(true);
        available_seats.add(index, boughtSeat);

    }

}
