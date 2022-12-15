import org.threeten.bp.OffsetDateTime;

//create Event class
class Event {

    public OffsetDateTime updated_time;

    // parameterized constructor
    public Event(){}
    Event(OffsetDateTime updatedTime) {
        this.updated_time = updatedTime;
    }
}
