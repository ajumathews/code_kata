package theory.liveness.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
Here each philosopher should acquire two locks for having Sushi- left and right.

Aju has taken leftChopStick and  then take right chopstick and took sushi.
Then released it.
Now Ammu will take rightChopstick first and then left and took sushi.
This is the positive scenario

Now say aju has taken leftChopStick and at the same time Ammu has taken right Chopstick
Now aju will wait for Ammu to release right chopstick , whereas ammu will wait aju to release leftchopstick.
This is dead theory.lock

* */

public class Main {

    public static void main(String[] args) {
        Lock leftChopStick = new ReentrantLock();
        Lock rightChopStick = new ReentrantLock();


        Thread aju = new Thread(new Philospher(leftChopStick, rightChopStick), "aju");
        Thread ammu = new Thread(new Philospher(rightChopStick, leftChopStick), "ammu");

        aju.start();
        ammu.start();
    }
}
