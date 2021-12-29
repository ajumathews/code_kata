package theory.structural.facade.withFacade;

public class Booking {

 private AirTicketFacade airTicketFacade;
 private MovieTicketFacade movieTicketFacade;

    public Booking(AirTicketFacade airTicketFacade, MovieTicketFacade movieTicketFacade) {
        this.airTicketFacade = airTicketFacade;
        this.movieTicketFacade = movieTicketFacade;
    }

    public void findAirLineTickets(){
        this.airTicketFacade.findFlightTickets();
    }

    public void findMovieTickets(){
        this.movieTicketFacade.findMovieTickets();
    }
}
