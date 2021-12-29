package theory.behaviour.command.withCommand;

/*

Here Remote Class is decoupled from Devices
Suppose we wanted to change the button 1 and 2   functionality - To turn on and off
Then we just need to set the commands on that button. its very flexible to do.

* */

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        AirConditioner airConditioner = new AirConditioner();

        System.out.println("Created Remote with default Buttons");
        Remote remote = new Remote(new LightOnCommand(light),
                new LightOffCommand(light),
                new TemperatureUpCommand(airConditioner),
                new TemperatureDownCommand(airConditioner));

        remote.clickButton1();
        remote.clickButton2();
        remote.clickButton3();
        remote.clickButton4();

        System.out.println("Updated Buttons 1 an 2 to turn Ac on and Off");
        remote.setButton1(new AirConditionOnCommand(airConditioner));
        remote.setButton2(new AirConditionOffCommand(airConditioner));
        remote.clickButton1();
        remote.clickButton2();
        remote.clickButton3();
        remote.clickButton4();

    }
}
