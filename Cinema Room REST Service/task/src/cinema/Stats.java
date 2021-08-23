package cinema;

import com.sun.net.httpserver.HttpsConfigurator;

public class Stats {
    int current_income;
    int number_of_available_seats;
    int number_of_purchased_tickets;

    Stats() {

    }

    Stats(int income, int unsoldSeats, int ticketsPurchased) {
        current_income = income;
        number_of_available_seats = unsoldSeats;
        number_of_purchased_tickets = ticketsPurchased;
    }

    public int getCurrent_income() {
        return current_income;
    }

    public void setCurrent_income(int current_income) {
        this.current_income = current_income;
    }

    public int getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public void setNumber_of_available_seats(int number_of_available_seats) {
        this.number_of_available_seats = number_of_available_seats;
    }

    public int getNumber_of_purchased_tickets() {
        return number_of_purchased_tickets;
    }

    public void setNumber_of_purchased_tickets(int number_of_purchased_tickets) {
        this.number_of_purchased_tickets = number_of_purchased_tickets;
    }
}
