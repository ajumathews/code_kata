package theory.lock.readWrite.withOutLock;

import java.util.concurrent.locks.Lock;

public class StockPriceReader implements Runnable {

    private Stock stock;
    private Lock lock;

    public StockPriceReader(Stock stock, Lock lock) {
        this.stock = stock;
        this.lock = lock;
    }


    @Override
    public void run() {
        while (stock.isTradingOpen()) {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " reading Price :" + stock.getStockPrice());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
            lock.unlock();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
        }
    }
}
