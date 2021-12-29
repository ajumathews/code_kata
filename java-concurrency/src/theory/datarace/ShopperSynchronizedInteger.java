package theory.datarace;

/*

Here we are locking on the Integer. And we will get incorrect data as the count because Integer is a immutable class
and each increment creates a new integer. so we are locking on different objects

 */
public class ShopperSynchronizedInteger implements Runnable {

    private Integer garlicCount = new Integer(0);

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            synchronized (garlicCount) {
                garlicCount++;
            }
        }
    }

    public int getGarlicCount() {
        return garlicCount;
    }

    public static void main(String[] args) throws InterruptedException {
        ShopperSynchronizedInteger shopper = new ShopperSynchronizedInteger();
        Thread aju = new Thread(shopper, "aju");
        Thread ammu = new Thread(shopper, "ammu");
        aju.start();
        ammu.start();
        aju.join();
        ammu.join();
        System.out.println(shopper.getGarlicCount());
    }
}
