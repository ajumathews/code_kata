package theory.synchronization.with;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Here there is a condition created and when the worker comes, and if there are no new task
then it goes to wait state.

Now when the manager creates a new task, it notifys all the other threads so they continue exections
from wait state.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Office clarivate = new Office();
        Manager vijay = new Manager(0);
        Worker aju = new Worker();
        Worker babu = new Worker();
        Worker pavan = new Worker();
        Lock cabindoor = new ReentrantLock();
        Condition newTaskAvailable = cabindoor.newCondition();

        new Thread(clarivate, "clarivate").start();
        Thread.sleep(1000);
        new Thread(new TaskFinder(vijay, cabindoor, clarivate, newTaskAvailable), "vijay").start();
        new Thread(new TaskScheduler(aju, vijay, cabindoor, clarivate, newTaskAvailable), "aju").start();
        new Thread(new TaskScheduler(babu, vijay, cabindoor, clarivate, newTaskAvailable), "babu").start();
        new Thread(new TaskScheduler(pavan, vijay, cabindoor, clarivate, newTaskAvailable), "pavan").start();


    }
}
