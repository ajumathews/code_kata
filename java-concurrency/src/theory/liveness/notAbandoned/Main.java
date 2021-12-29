package theory.liveness.notAbandoned;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
In This case, one of the thread terminates abruptly without releasing the theory.lock.
So all the other threads be in dead theory.lock waiting.
* */

public class Main {

    public static void main(String[] args) {
        Lock leftChopStick = new ReentrantLock();
        Lock rightChopStick = new ReentrantLock();


        Thread aju = new Thread(new Philospher(leftChopStick, rightChopStick), "aju");
        Thread ammu = new Thread(new Philospher(leftChopStick, rightChopStick), "ammu");

        aju.start();
        ammu.start();
    }
}
