package theory.synchronization.with;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TaskScheduler implements Runnable {

    private Worker worker;
    private Manager manager;
    private Lock cabinDoor;
    private Office office;
    private Condition newTaskAvailable;

    public TaskScheduler(Worker worker, Manager manager, Lock cabinDoor, Office office, Condition newTaskAvailable) {
        this.worker = worker;
        this.manager = manager;
        this.cabinDoor = cabinDoor;
        this.office = office;
        this.newTaskAvailable = newTaskAvailable;
    }

    @Override
    public void run() {
        while (!office.isEndOfDay()) {
            cabinDoor.lock();
            if (manager.getCurrentTasks() <= 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + " Waiting for New tasks from Manager");
                    newTaskAvailable.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (manager.getCurrentTasks() > 0) {
                worker.incrementTasksDone();
                manager.decrementCurrentTasks();
                System.out.println(Thread.currentThread().getName() + " Got new task from manager");
            }
            cabinDoor.unlock();

            /*Workers working/Waiting*/
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Task Assigned to " + Thread.currentThread().getName() + " " + worker.getTasksDone());

    }
}
