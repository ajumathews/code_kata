package theory.behaviour.observer.withoutObserver;

public class TVDisplay implements Display{

    private float currentTemperature;

    private WeatherMonitoringSystem weatherMonitoringSystem;

    public TVDisplay(WeatherMonitoringSystem weatherMonitoringSystem){
        this.weatherMonitoringSystem = weatherMonitoringSystem;
    }

    public void checkForLatestData(){
        if(weatherMonitoringSystem.getTemperature()!=currentTemperature){
            currentTemperature=weatherMonitoringSystem.getTemperature();
        }
    }

    public void showDisplay() {
        System.out.println("Displaying Temperature in TV :" + this.currentTemperature);
    }
}
