package theory.behaviour.command.withoutCommand;

public class Remote {
    private Light light;
    private AirConditioner airConditioner;

    public Remote(Light musicSystem, AirConditioner airConditioner) {
        this.light = musicSystem;
        this.airConditioner = airConditioner;
    }

    public void clickButton1() {
        System.out.print("button 1 clicked : ");
        light.lightOn();
    }

    public void clickButton2() {
        System.out.print("button 2 clicked : ");
        light.lightOff();
    }

    public void clickButton3() {
        System.out.print("button 3 clicked : ");
        airConditioner.temperatureUp();
    }

    public void clickButton4() {
        System.out.print("button 4 clicked : ");
        airConditioner.temperatureDown();
    }
}
