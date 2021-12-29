package theory.behaviour.command.withCommand;

public class    Remote {
    private Command button1;
    private Command button2;
    private Command button3;
    private Command button4;

    public Remote(Command on, Command off, Command volumeUp, Command volumeDown) {
        this.button1 = on;
        this.button2 = off;
        this.button3 = volumeUp;
        this.button4 = volumeDown;
    }

    public void setButton1(Command button1) {
        this.button1 = button1;
    }

    public void setButton2(Command button2) {
        this.button2 = button2;
    }

    public void setButton3(Command button3) {
        this.button3 = button3;
    }

    public void setButton4(Command button4) {
        this.button4 = button4;
    }

    public void clickButton1() {
        System.out.print("button 1 clicked : ");
        button1.execute();
    }

    public void clickButton2() {
        System.out.print("button 2 clicked : ");
        button2.execute();
    }

    public void clickButton3() {
        System.out.print("button 3 clicked : ");
        button3.execute();
    }

    public void clickButton4() {
        System.out.print("button 4 clicked : ");
        button4.execute();
    }
}
