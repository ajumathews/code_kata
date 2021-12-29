package theory.lock.readWrite.withOutLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 Here we have one Thread updating the stock price and 100 threads reading the price.
 So if we have a normal theory.lock, we can ensure there is no race condition.
 But it will slow down the application since all these 101 threads wait for the theory.lock.
 But essentially we need to get theory.lock from all read threads when there is an update operation.
Between multiple read threads we dont need any locking since they are not updating the value.
  */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Stock stock = new Stock();
        Lock lock = new ReentrantLock();

        Thread stockTradingController = new Thread(new StockTradingController(stock, lock));
        stockTradingController.start();

        Thread.sleep(2000);

        for (int i = 0; i < 1; i++) {
            new Thread(new StockPriceUpdater(stock, lock), "Updater "+i ).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(new StockPriceReader(stock, lock), "Reader " + i).start();
        }
    }
}
