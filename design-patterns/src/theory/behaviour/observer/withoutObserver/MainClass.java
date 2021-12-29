package theory.behaviour.observer.withoutObserver;

/*
 This is basically a Pull mechanism where the Display terminals have to keep polling the Weather Station
 to check is the temperature has changed. There is no way to inform the terminals by the weather station
 once the temperature is updated.

 We need a push mechanism. By Observer pattern we can achieve this.

* */

public class MainClass {

    public static void main(String[] args) {
        WeatherMonitoringSystem weatherMonitoringSystem= new WeatherMonitoringSystem();

        PhoneDisplay phoneDisplay = new PhoneDisplay(weatherMonitoringSystem);
        TVDisplay tvDisplay = new TVDisplay(weatherMonitoringSystem);

        System.out.println("Displaying Initial Temperature");
        phoneDisplay.showDisplay();
        tvDisplay.showDisplay();

        /*Updating Weather Monitoring Temperature*/
        System.out.println("Weather Monitoring System updated");
        weatherMonitoringSystem.updateTemperature();


        System.out.println("Displaying Temperature");
        phoneDisplay.showDisplay();
        tvDisplay.showDisplay();

        System.out.println("Displaying Temperature after polling to weather station");
        phoneDisplay.checkForLatestData();
        tvDisplay.checkForLatestData();
        phoneDisplay.showDisplay();
        tvDisplay.showDisplay();

    }
}
