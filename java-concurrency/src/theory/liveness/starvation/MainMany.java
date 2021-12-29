package theory.liveness.starvation;

import theory.liveness.withoutStarvation.Philospher;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
Here we can see many philosophers having 0 sushis taken even with the same chopsticks

* */

public class MainMany {

    public static void main(String[] args) {
        Lock leftChopStick = new ReentrantLock();
        Lock rightChopStick = new ReentrantLock();

        for (int i = 0; i < 1000; i++) {
            new Thread(new Philospher(leftChopStick, rightChopStick), "philosopher " + i).start();
        }


    }
}
