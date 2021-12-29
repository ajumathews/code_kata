package theory.liveness.abandoned;

import java.util.concurrent.locks.Lock;

public class Philospher implements Runnable {


    private Lock chopStickLeft;
    private Lock chopStickRight;
    private static int sushiCount=100;

    public Philospher(Lock chopstickleft, Lock chopStickRight) {
        this.chopStickLeft = chopstickleft;
        this.chopStickRight = chopStickRight;
    }

    @Override
    public void run() {
        while (sushiCount > 0) {
            chopStickLeft.lock();
            chopStickRight.lock();

            if (sushiCount > 0) {
                sushiCount--;
                System.out.println(Thread.currentThread().getName() + " eating Sushi. Remaining sushi=" + sushiCount);
            }

            if(sushiCount ==50){
                sushiCount =1/0;
            }

            chopStickRight.unlock();
            chopStickLeft.unlock();
        }
    }
}
