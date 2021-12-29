package theory.structural.facade.withFacade;

public class MovieTicketFacade {

    private BookMyshow bookMyshow;

    public MovieTicketFacade(BookMyshow bookMyshow) {
        this.bookMyshow = bookMyshow;
    }

    public void findMovieTickets() {
        bookMyshow.findMovieTickets();
    }
}
