package theory.behaviour.command.withCommand;

public class TemperatureUpCommand implements Command {

    private AirConditioner airConditioner;

    public TemperatureUpCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.temperatureUp();
    }
}
