package theory.synchronization.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
BlockingQueue is the threadsafe implementation.
It handles the race condition and dead theory.lock.

* */
public class Main {

    public static void main(String[] args) {
        BlockingQueue taskQueue = new ArrayBlockingQueue<String>(10);

        new Thread(new Manager(taskQueue), "vijay").start();
        new Thread(new Worker(taskQueue), "aju").start();
        new Thread(new Worker(taskQueue), "babu").start();
        new Thread(new Worker(taskQueue), "pavan").start();

    }
}
