package theory.lock.readWrite.withLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StockPriceUpdater implements Runnable {

    private Stock stock;
    private Random random;
    private Lock updateLock;

    public StockPriceUpdater(Stock stock, ReentrantReadWriteLock lock) {
        this.stock = stock;
        this.random = new Random();
        updateLock = lock.writeLock();
    }


    @Override
    public void run() {
        while (stock.isTradingOpen()) {
            updateLock.lock();
            int change = random.nextInt(10);
            if (random.nextBoolean()) {
                change = -change;
            }
            System.out.println(Thread.currentThread().getName() + " Updating Price :" + change);
            stock.updateStockPrice(change);
            updateLock.unlock();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
            }
        }

    }
}
