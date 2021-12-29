package theory.behaviour.command.withCommand;

public class AirConditionOffCommand implements Command {

    private AirConditioner airConditioner;

    public AirConditionOffCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.airconditionOff();
    }
}
