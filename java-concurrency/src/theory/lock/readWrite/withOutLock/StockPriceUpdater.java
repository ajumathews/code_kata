package theory.lock.readWrite.withOutLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;

public class StockPriceUpdater implements Runnable {

    private Stock stock;
    private Random random;
    private Lock lock;

    public StockPriceUpdater(Stock stock, Lock lock) {
        this.stock = stock;
        this.random = new Random();
        this.lock = lock;
    }


    @Override
    public void run() {
        while (stock.isTradingOpen()) {
            lock.lock();
            int change = random.nextInt(10);
            if (random.nextBoolean()) {
                change = -change;
            }
            System.out.println(Thread.currentThread().getName() + " Updating Price :" + change);
            stock.updateStockPrice(change);
            lock.unlock();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
            }
        }

    }
}
