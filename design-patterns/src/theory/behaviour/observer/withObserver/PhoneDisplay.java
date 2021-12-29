package theory.behaviour.observer.withObserver;

public class PhoneDisplay implements Display {

    private float currentTemperature;

    public void updateTemperature(float temperature) {
        this.currentTemperature = temperature;
    }

    public void showDisplay() {
        System.out.println("Displaying Temperature in Phone :" + this.currentTemperature);
    }
}
