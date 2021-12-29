package theory.structural.facade.withFacade;

/*

Its based on the Principle of least knowledge -Talk only to your friend
We have created an AirticketFacade and MovieTicketFacade.

So the booking class doesnt have much to do.

* */

public class Main {
    public static void main(String[] args) {
       AirTicketFacade airTicketFacade = new AirTicketFacade(new GoIbibo(),new MakeMyTrip());
       MovieTicketFacade movieTicketFacade = new MovieTicketFacade(new BookMyshow());

       Booking booking = new Booking(airTicketFacade,movieTicketFacade);
       booking.findMovieTickets();
       booking.findAirLineTickets();
    }
}
