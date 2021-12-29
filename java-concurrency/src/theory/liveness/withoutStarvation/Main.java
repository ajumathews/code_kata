package theory.liveness.withoutStarvation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
Here because all three are using the same chopsticks , all get a fare share 
* */

public class Main {

    public static void main(String[] args) {
        Lock leftChopStick = new ReentrantLock();
        Lock rightChopStick = new ReentrantLock();
        Lock optionalChopstick = new ReentrantLock();


        Thread aju = new Thread(new Philospher(leftChopStick, rightChopStick), "aju");
        Thread ammu = new Thread(new Philospher(leftChopStick, rightChopStick), "ammu");
        Thread vavachi = new Thread(new Philospher(leftChopStick, rightChopStick), "vavachi");


        aju.start();
        ammu.start();
        vavachi.start();
    }
}
