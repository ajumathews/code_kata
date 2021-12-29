package theory.behaviour.command.withCommand;

public class AirConditionOnCommand implements Command {

    private AirConditioner airConditioner;

    public AirConditionOnCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.airconditionOn();
    }
}
