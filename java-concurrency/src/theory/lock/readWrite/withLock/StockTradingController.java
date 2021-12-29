package theory.lock.readWrite.withLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StockTradingController implements Runnable {

    private Stock stock;
    private Lock updateLock;

    public StockTradingController(Stock stock, ReentrantReadWriteLock lock) {
        this.stock = stock;
        updateLock = lock.writeLock();
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println("Market Opened with the Price :" + stock.getStockPrice());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
        } finally {
            updateLock.lock();
            stock.setTradingOpen(false);
            System.out.println("Market Closed with the Price :" + stock.getStockPrice());
            System.out.println("Time taken : "+(System.currentTimeMillis() -startTime));
            updateLock.unlock();
        }
    }
}
