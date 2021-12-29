package theory.datarace;

import java.util.concurrent.atomic.AtomicInteger;

/*
Here garlicCount is an Atomic variable. It ensures that  no two threads modify at the same time.

*/
public class ShopperAtomic implements Runnable {

    private AtomicInteger garlicCount= new AtomicInteger();

    @Override
    public void run() {
        for(int i=0;i<1000000;i++){
            garlicCount.getAndIncrement();
        }
    }

    public AtomicInteger getGarlicCount() {
        return garlicCount;
    }

    public static void main(String[] args) throws InterruptedException {
        ShopperAtomic shopper = new ShopperAtomic();
        Thread aju = new Thread(shopper);
        Thread ammu= new Thread(shopper);
        aju.start();
        ammu.start();
        aju.join();
        ammu.join();
        System.out.println(shopper.getGarlicCount());
    }
}
