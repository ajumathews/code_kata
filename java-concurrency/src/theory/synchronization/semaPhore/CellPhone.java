package theory.synchronization.semaPhore;

import theory.synchronization.with.Manager;

import java.util.concurrent.Semaphore;

public class CellPhone implements Runnable{

    private Semaphore chargingPoints;

    public CellPhone(Semaphore chargingPoints) {
        this.chargingPoints = chargingPoints;
    }



    @Override
    public void run() {
        try {
            chargingPoints.acquire();
            System.out.println(Thread.currentThread().getName()+" charging");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            chargingPoints.release();
            System.out.println(Thread.currentThread().getName()+" done");
        }
    }
}
