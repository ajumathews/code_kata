package theory.datarace;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Here we are using Lock to theory.lock the critical section
*/
public class ShopperLock implements Runnable {

    private int garlicCount;
    private Lock shopKey = new ReentrantLock();

    @Override
    public void run() {
        for(int i=0;i<1000000;i++){
            shopKey.lock();
            garlicCount++;
            shopKey.unlock();
        }
    }

    public int getGarlicCount() {
        return garlicCount;
    }

    public static void main(String[] args) throws InterruptedException {
        ShopperLock shopper = new ShopperLock();
        Thread aju = new Thread(shopper);
        Thread ammu= new Thread(shopper);
        aju.start();
        ammu.start();
        aju.join();
        ammu.join();
        System.out.println(shopper.getGarlicCount());
    }
}
