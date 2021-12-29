package theory.behaviour.observer.withObserver;

public class TVDisplay implements Display {

    private float currentTemperature;

    @Override
    public void updateTemperature(float temperature) {
        this.currentTemperature = temperature;
    }

    public void showDisplay() {
        System.out.println("Displaying Temperature in TV :" + this.currentTemperature);
    }
}
