package theory.racecondition.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shopper extends Thread {

    public static int chipsPacket;
    private static Lock pencil = new ReentrantLock();
    private static CountDownLatch countDownLatch = new CountDownLatch(5);
    private String name;

    public Shopper(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (name.equals("aju")) {
            chipsPacket += 5;
            System.out.println(name + " added three bags of chips.");
           countDownLatch.countDown();
        } else {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            chipsPacket *= 2;
            System.out.println(name + " doubled bags of chips.");

        }
    }
}
