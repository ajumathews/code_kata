package theory.synchronization.without;

import java.util.concurrent.locks.Lock;

public class TaskScheduler implements Runnable {

    private Worker worker;
    private Manager manager;
    private Lock cabinDoor;
    private Office office;

    public TaskScheduler(Worker worker, Manager manager, Lock cabinDoor, Office office) {
        this.worker = worker;
        this.manager = manager;
        this.cabinDoor = cabinDoor;
        this.office = office;
    }

    @Override
    public void run() {
        while (!office.isEndOfDay()) {
            cabinDoor.lock();
            if (manager.getCurrentTasks() > 0) {
                worker.incrementTasksDone();
                manager.decrementCurrentTask();
                System.out.println(Thread.currentThread().getName() + " Got new Task from manager");
            } else {
                System.out.println(Thread.currentThread().getName() + " Returned without Task");
            }
            cabinDoor.unlock();

            /*workers Working/Waiting*/
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Task Assigned to " + Thread.currentThread().getName() + " " + worker.getTasksDone());

    }
}
