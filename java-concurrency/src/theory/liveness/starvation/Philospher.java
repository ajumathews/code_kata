package theory.liveness.starvation;

import java.util.concurrent.locks.Lock;

public class Philospher implements Runnable {


    private Lock chopStickLeft;
    private Lock chopStickRight;
    private static int sushiCount = 100000;

    public Philospher(Lock chopstickleft, Lock chopStickRight) {
        this.chopStickLeft = chopstickleft;
        this.chopStickRight = chopStickRight;
    }

    @Override
    public void run() {
        int sushisEaten = 0;
        while (sushiCount > 0) {
            chopStickLeft.lock();
            chopStickRight.lock();

            if (sushiCount > 0) {
                sushiCount--;
                sushisEaten++;
                System.out.println(Thread.currentThread().getName() + " eating Sushi. Remaining sushi=" + sushiCount);
            }

            chopStickRight.unlock();
            chopStickLeft.unlock();
        }
        System.out.println(Thread.currentThread().getName() + " Sushis Eaten=" + sushisEaten);

    }
}
