package theory.lock.readWrite.withLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StockPriceReader implements Runnable {

    private Stock stock;
    private Lock readLock;

    public StockPriceReader(Stock stock, ReentrantReadWriteLock lock) {
        this.stock = stock;
        this.readLock = lock.readLock();
    }


    @Override
    public void run() {
        while (stock.isTradingOpen()) {
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + " reading Price :" + stock.getStockPrice());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
            readLock.unlock();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
        }
    }
}
