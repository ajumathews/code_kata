package theory.structural.facade.withFacade;

public class AirTicketFacade {

    private GoIbibo goIbibo;
    private MakeMyTrip makeMyTrip;

    public AirTicketFacade(GoIbibo goIbibo, MakeMyTrip makeMyTrip) {
        this.goIbibo = goIbibo;
        this.makeMyTrip = makeMyTrip;
    }

    public void findFlightTickets() {
        goIbibo.getTickets();
        makeMyTrip.getTickets();
    }
}
