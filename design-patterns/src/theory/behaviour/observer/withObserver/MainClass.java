package theory.behaviour.observer.withObserver;

/*
Here once the weather station temperature is updated. the values are pushed to getButtonColor terminals

* */

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {

        PhoneDisplay phoneDisplay = new PhoneDisplay();
        TVDisplay tvDisplay = new TVDisplay();

        List<Display> displayList = new ArrayList<>();
        displayList.add(phoneDisplay);
        displayList.add(tvDisplay);
        WeatherMonitoringSystem weatherMonitoringSystem= new WeatherMonitoringSystem(displayList);


        System.out.println("Displaying Initial Temperature");
        phoneDisplay.showDisplay();
        tvDisplay.showDisplay();

        /*Updating Weather Monitoring Temperature*/
        System.out.println("Weather Monitoring System updated, the values are being pushed to all the getButtonColor terminals");
        weatherMonitoringSystem.updateTemperature();


        System.out.println("Displaying Temperature");
        phoneDisplay.showDisplay();
        tvDisplay.showDisplay();


    }
}
