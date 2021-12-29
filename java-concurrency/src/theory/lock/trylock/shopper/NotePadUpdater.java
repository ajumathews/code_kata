package theory.lock.trylock.shopper;

import java.util.concurrent.locks.Lock;

public class NotePadUpdater extends Thread {

    private Shopper shopper;
    private NotePad notePad;
    private Lock pencil;


    public NotePadUpdater(String name, Shopper shopper, NotePad notePad, Lock lock) {
        super(name);
        this.shopper = shopper;
        this.notePad = notePad;
        this.pencil = lock;
    }

    @Override
    public void run() {
        while (notePad.getItemsInNotePad() < 50) {
            if (shopper.getItemsToAdd() > 0) {
                pencil.lock();
                notePad.setItemsInNotePad(notePad.getItemsInNotePad() + shopper.getItemsToAdd());
                System.out.println(Thread.currentThread().getName() + " Writing items to NotePad :" + shopper.getItemsToAdd());
                shopper.setItemsToAdd(0);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                } finally {
                    pencil.unlock();
                }
            } else {
                shopper.setItemsToAdd(shopper.getItemsToAdd() + 1);
                System.out.println(Thread.currentThread().getName() + " Browsing to find items to buy : " + shopper.getItemsToAdd());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }


        }
    }
}
