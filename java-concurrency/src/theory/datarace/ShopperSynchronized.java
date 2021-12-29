package theory.datarace;

/*

Here we are locking on the object itself

In the first method we locked full run method, in the second , we are locking only the critical section.

 */
public class ShopperSynchronized implements Runnable {

    private int garlicCount;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                garlicCount++;
                System.out.println(Thread.currentThread().getName() + " sleeping");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

            }
        }
    }

   /* @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (this) {
                garlicCount++;
            }
            System.out.println(Thread.currentThread().getName() + " sleeping");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }


        }
    }*/

    public int getGarlicCount() {
        return garlicCount;
    }

    public static void main(String[] args) throws InterruptedException {
        ShopperSynchronized shopper = new ShopperSynchronized();
        Thread aju = new Thread(shopper, "aju");
        Thread ammu = new Thread(shopper, "ammu");
        aju.start();
        ammu.start();
        aju.join();
        ammu.join();
        System.out.println(shopper.getGarlicCount());
    }
}
