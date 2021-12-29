package theory.liveness.withoutDeadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
To Solve the deadlock, we have given priority to chopsticks.
And each thread should posses them in the same order.


leftChopStick - 1
rightChopStick - 2

Now we wont end up in deadlock
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
