package theory.lock.readWrite.withLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
Here we have used a ReadWriteLock .
Write theory.lock is used for Updating
Read Lock is used for Reading.

All 100 read threads dont need to compete with each other and it will be very faster.
When there is an update operaton it needs to get the theory.lock.

So this improves the performance significantly
  */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Stock stock = new Stock();
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Thread stockTradingController = new Thread(new StockTradingController(stock, lock));
        stockTradingController.start();

        Thread.sleep(2000);

        for (int i = 0; i < 1; i++) {
            new Thread(new StockPriceUpdater(stock, lock), "Updater "+i).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(new StockPriceReader(stock, lock), "Reader " + i).start();
        }

    }
}
