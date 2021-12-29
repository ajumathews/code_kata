package theory.racecondition.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shopper extends Thread {

    public static int chipsPacket;
    private static Lock pencil = new ReentrantLock();
    private static CyclicBarrier barrier = new CyclicBarrier(10);
    private String name;

    public Shopper(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (name.equals("aju")) {
            chipsPacket += 5;
            System.out.println(name + " added three bags of chips.");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        } else {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            chipsPacket *= 2;
            System.out.println(name + " doubled bags of chips.");

        }
    }
}
