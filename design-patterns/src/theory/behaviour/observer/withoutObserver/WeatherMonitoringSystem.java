package theory.behaviour.observer.withoutObserver;

import java.util.Random;

public class WeatherMonitoringSystem {

    private float temperature;

    public void updateTemperature(){
        /*Code to get data from different sensors and compute the current temperature*/
        this.temperature = new Random().nextFloat();
    }

    public float getTemperature() {
        return temperature;
    }
}
