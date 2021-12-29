package theory.behaviour.command.withCommand;

public class TemperatureDownCommand implements Command {

    private AirConditioner airConditioner;

    public TemperatureDownCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.temperatureDown();
    }
}
