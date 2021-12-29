package practice.basic;

import java.util.concurrent.Semaphore;

public class Test {

    public static void main(String[] args) {

        Semaphore chargingPoints = new Semaphore(4);



    }

}


class CellPhone implements Runnable {

    private Semaphore chargingPoint;

    public CellPhone(Semaphore chargingPoint) {
        this.chargingPoint = chargingPoint;
    }

    @Override
    public void run() {
        try {
            chargingPoint.acquire();
            Thread.sleep(1000);
        } catch (InterruptedException ex) {

        } finally {
            chargingPoint.release();
        }
    }
}