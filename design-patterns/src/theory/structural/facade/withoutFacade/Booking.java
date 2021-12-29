package theory.structural.facade.withoutFacade;

public class Booking {

    private GoIbibo goIbibo;
    private MakeMyTrip makeMyTrip;
    private BookMyshow bookMyshow;

    public Booking(GoIbibo goIbibo, MakeMyTrip makeMyTrip,BookMyshow bookMyshow) {
        this.goIbibo = goIbibo;
        this.makeMyTrip = makeMyTrip;
        this.bookMyshow= bookMyshow;
    }

    public void findFlightTickets() {
        goIbibo.getTickets();
        makeMyTrip.getTickets();
    }

    public void findMovieTickets() {
       bookMyshow.findMovieTickets();
    }
}
