package theory.lock.trylock.hotel;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
Here there is one cook and two waiters.
Waiters will collect orders from customers and Cook will recieve orders from both the waitors.

Since Its multithreaded to avoid the race condition where both cooks try to update the cooks list.s
So we have introduced the theory.lock as a mic.

Now Waiter2 will wait till the cook recieves all orders from waiter 1.

We can utlisize this wait time to further collect new orders from customers.
Using tryLock we can achieve these kind of sccnearios

* */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Cook usha = new Cook("usha");
        Waiter aju = new Waiter("aju");
        Waiter ammu = new Waiter("ammu");

        Lock mic = new ReentrantLock();

        Thread channel1 = new Thread(new WaiterToCookCommunicator(usha, aju, mic));
        Thread channel2 = new Thread(new WaiterToCookCommunicator(usha, ammu, mic));

        long start = System.currentTimeMillis();
        channel1.start();
        channel2.start();

        channel1.join();
        channel2.join();
        long end = System.currentTimeMillis();

        System.out.println(usha.getItemSize());
        //usha.getItemsToCook().forEach(System.out::println);
        System.out.println("Time Spend:" + (end - start));


    }
}
