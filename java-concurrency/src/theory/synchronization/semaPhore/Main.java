package theory.synchronization.semaPhore;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore chargingPoint = new Semaphore(4);
        for (int i = 0; i < 10; i++) {
            new Thread(new CellPhone(chargingPoint), "cell " + i).start();
        }
    }
}
