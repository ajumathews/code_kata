package theory.behaviour.command.withoutCommand;

/*
Here The Remote class is tightly coupled with the Devices Light and AC
Suppose we wanted to change the button 1 and 2   functionality - To turn on and off
Then we have to change the remote class click button methods .

This is not flexible

*/
public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        AirConditioner airConditioner = new AirConditioner();
        Remote remote = new Remote(light,airConditioner);
        remote.clickButton1();
        remote.clickButton2();
        remote.clickButton3();
        remote.clickButton4();
    }
}
