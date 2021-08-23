package cinema;

public class ReturnedTicket {

    MovieSeat returned_ticket;

    ReturnedTicket(MovieSeat seat) {
        returned_ticket = new MovieSeat(seat.getRow(), seat.getColumn());

    }

    public MovieSeat getReturned_ticket() {
        return returned_ticket;
    }

    public void setReturned_ticket(MovieSeat returned_ticket) {
        this.returned_ticket = returned_ticket;
    }
}
