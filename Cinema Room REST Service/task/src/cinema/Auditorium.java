package cinema;

import java.util.*;

public class Auditorium {

    private final int total_rows = 9;
    private final int total_columns = 9;  //  Collections.synchronizedList(new ArrayList<>());
    List<MovieSeat> available_seats;
    //private List<MovieSeat> allSeats;
    private boolean[][] seatPurchased;

    Auditorium() {
        //allSeats = new ArrayList<>();
        seatPurchased = new boolean[total_rows][total_columns];
        for (boolean[] row : seatPurchased) {
            Arrays.fill(row, false);
                // MovieSeat currentSeat = new MovieSeat(row, col);
                //available_seats.add(currentSeat);
                //allSeats.add(currentSeat);


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
        for (int row = 0; row < total_rows; row++) {
            for (int column = 0; column < total_columns; column++) {
                if (!seatPurchased[row][column]) {
                    MovieSeat seat = new MovieSeat(row + 1, column + 1);
                    available_seats.add(seat);
                }
            }
         }
        return available_seats;
    }

    public void setAvailable_seats(List<MovieSeat> available_seats) {
        this.available_seats = available_seats;
    }
    public int getSeat(int row, int col) {
        int temp = col + ((row - 1) * 10) - row;
        System.out.println("index is " + temp);
        return temp;

    }


    public boolean isSeatPurchased(MovieSeat seat) {
        /*
        int index = getSeat(seat.getRow(), seat.getColumn());
        MovieSeat currentSeat = allSeats.get(index);*/

        return seatPurchased[seat.getRow() - 1][seat.getColumn() - 1];
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
        seatPurchased[seat.getRow() - 1][seat.getColumn() - 1] = true;

        //int index = getSeat(seat.getRow(), seat.getColumn());
        //allSeats.get(index).setPurchased(true);
        /*
        MovieSeat boughtSeat = allSeats.remove(index);
        boughtSeat.setPurchased(true);
        allSeats.add(index, boughtSeat);*/

    }

}
