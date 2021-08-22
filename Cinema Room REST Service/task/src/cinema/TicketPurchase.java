package cinema;

import java.util.UUID;


public class TicketPurchase {

    UUID token;
    MovieSeat ticket;

    TicketPurchase(MovieSeat seat) {
        token = UUID.randomUUID();
        ticket = seat;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public MovieSeat getTicket() {
        return ticket;
    }

    public void setTicket(MovieSeat ticket) {
        this.ticket = ticket;
    }





}
