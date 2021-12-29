package theory.lock.trylock.shopper;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Shopper aju = new Shopper("aju");
        Shopper ammu = new Shopper("ammu");

        NotePad notePad = new NotePad();
        Lock lock = new ReentrantLock();
        NotePadUpdater ajuThread = new NotePadUpdater("aju", aju, notePad,lock);
        NotePadUpdater ammuThread = new NotePadUpdater("ammmu", ammu, notePad,lock);

        long start = System.currentTimeMillis();
        ajuThread.start();
        ammuThread.start();
        ajuThread.join();
        ammuThread.join();
        long end = System.currentTimeMillis();
        System.out.println("Items in Notepad :" + notePad.getItemsInNotePad());
        System.out.println("Time Spend:" + (end - start));


    }
}
