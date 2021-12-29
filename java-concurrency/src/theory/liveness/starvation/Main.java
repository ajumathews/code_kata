package theory.liveness.starvation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
Here we can see the no of Sushis eaten is not fare.

* */

public class Main {

    public static void main(String[] args) {
        Lock leftChopStick = new ReentrantLock();
        Lock rightChopStick = new ReentrantLock();
        Lock optionalChopstick = new ReentrantLock();


        Thread aju = new Thread(new Philospher(leftChopStick, rightChopStick), "aju");
        Thread ammu = new Thread(new Philospher(rightChopStick, optionalChopstick), "ammu");
        Thread vavachi = new Thread(new Philospher(leftChopStick, optionalChopstick), "vavachi");


        aju.start();
        ammu.start();
        vavachi.start();
    }
}
