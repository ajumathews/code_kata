package theory.synchronization.without;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
In this case , all the workers  come to the manager for the work after acquiring the cabin theory.lock.
If the manager has no work then they return back.

So we can see many worker threads coming to the cubicle seeking for work and returning without tasks.
*/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Office clarivate = new Office();
        Manager vijay = new Manager(0);
        Worker aju = new Worker();
        Worker babu = new Worker();
        Worker pavan = new Worker();
        Lock cabindoor = new ReentrantLock();

        new Thread(clarivate, "clarivate").start();
        Thread.sleep(1000);
        new Thread(new TaskFinder(vijay, cabindoor, clarivate), "vijay").start();
        new Thread(new TaskScheduler(aju, vijay, cabindoor, clarivate), "aju").start();
        new Thread(new TaskScheduler(babu, vijay, cabindoor, clarivate), "babu").start();
        new Thread(new TaskScheduler(pavan, vijay, cabindoor, clarivate), "pavan").start();


    }
}
