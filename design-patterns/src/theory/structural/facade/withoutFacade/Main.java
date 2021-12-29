package theory.structural.facade.withoutFacade;


/*

Here in the booking class we have flightTicket methods which talks to different subsystems to find tickets.
Booking is a generic class which will have multiple options like booking Movies , book rooms etc.




* */
public class Main {
    public static void main(String[] args) {
        Booking booking = new Booking(new GoIbibo(), new MakeMyTrip(),new BookMyshow());
        booking.findFlightTickets();
    }
}
