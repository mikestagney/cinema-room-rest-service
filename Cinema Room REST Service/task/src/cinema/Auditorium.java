package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

public class Auditorium {

    private final int total_rows = 9;
    private final int total_columns = 9;
    List<MovieSeat> available_seats;
    private boolean[][] seatPurchased;
    Map<UUID, MovieSeat> ticketPurchases;
    String password = "super_secret";


    Auditorium() {
        seatPurchased = new boolean[total_rows][total_columns];
        for (boolean[] row : seatPurchased) {
            Arrays.fill(row, false);
        }
        ticketPurchases = new HashMap<>();
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
        return seatPurchased[seat.getRow() - 1][seat.getColumn() - 1];
    }

    public Ticket buySeat(MovieSeat seat) {
        Ticket purchase = new Ticket(seat);
        seatPurchased[seat.getRow() - 1][seat.getColumn() - 1] = true;
        ticketPurchases.put(purchase.getToken(), seat);
        return purchase;
    }
    public boolean isTokenValid(Token token) {
        return ticketPurchases.containsKey(token.getToken());
    }
    public ReturnedTicket returnTicket(Token token) {
        MovieSeat returnedSeat = ticketPurchases.get(token.getToken());
        seatPurchased[returnedSeat.getRow() - 1][returnedSeat.getColumn() - 1] = false;
        ticketPurchases.remove(token.getToken());
        return new ReturnedTicket(returnedSeat);
    }
    @JsonIgnore
    public Stats getCurrentStats() {
       int ticketsPurchased = ticketPurchases.size();
       int seatsAvailable = total_rows * total_columns - ticketsPurchased;
       int income = 0;

       for (var ticket : ticketPurchases.entrySet()) {
           income += ticket.getValue().getPrice();
       }
       return new Stats(income, seatsAvailable, ticketsPurchased);
    }

}
