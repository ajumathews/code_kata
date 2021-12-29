package theory.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

/*

Here each thread calls the theory.lock method twice and unlock method twice.
If we are not doing that then it will lead to deadlock
*/
public class Shopper implements Runnable {
    private int garlicCount;
    private int potatoCount;
    private ReentrantLock pencil = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            addGarlic();
            addPotato();
        }
    }

    public void addGarlic() {
        pencil.lock();
        garlicCount++;
        addPotato();
        pencil.unlock();

    }

    public void addPotato() {
        pencil.lock();
        System.out.println(pencil.getHoldCount());
        potatoCount++;
        pencil.unlock();
    }


    public int getGarlicCount() {
        return garlicCount;
    }

    public int getPotatoCount() {
        return potatoCount;
    }

    public static void main(String[] args) throws InterruptedException {
        Shopper shopper = new Shopper();
        Thread aju = new Thread(shopper);
        Thread ammu = new Thread(shopper);
        aju.start();
        ammu.start();
        aju.join();
        ammu.join();
        System.out.println("Garlic count: " + shopper.getGarlicCount());
        System.out.println("Potato count: " + shopper.getPotatoCount());

    }
}
