package theory.lock.readWrite.withOutLock;

import java.util.concurrent.locks.Lock;

public class StockTradingController implements Runnable {

    private Stock stock;
    private Lock lock;

    public StockTradingController(Stock stock, Lock lock) {
        this.stock = stock;
        this.lock = lock;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println("Market Opened with the Price :" + stock.getStockPrice());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
        } finally {
            lock.lock();
            stock.setTradingOpen(false);
            System.out.println("Market Closed with the Price :" + stock.getStockPrice());
            System.out.println("Time taken : "+(System.currentTimeMillis() -startTime));
            lock.unlock();
        }
    }
}
