package theory.behaviour.observer.withObserver;

import java.util.List;
import java.util.Random;

public class WeatherMonitoringSystem {

    private List<Display> displayList;

    private float temperature;

    public WeatherMonitoringSystem(List<Display> displayList) {
        this.displayList = displayList;
    }

    public void updateTemperature() {
        /*Code to get data from different sensors and compute the current temperature*/
        this.temperature = new Random().nextFloat();
        for (Display display : displayList) {
            display.updateTemperature(this.temperature);
        }
    }

    public float getTemperature() {
        return temperature;
    }
}
