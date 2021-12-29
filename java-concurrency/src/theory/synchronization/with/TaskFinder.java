package theory.synchronization.with;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TaskFinder implements Runnable {

    private Manager manager;
    private Lock cabinDoor;
    private Office office;
    private Condition newTaskAvailable;

    public TaskFinder(Manager manager, Lock cabinDoor, Office office, Condition newTaskAvailable) {
        this.manager = manager;
        this.cabinDoor = cabinDoor;
        this.office = office;
        this.newTaskAvailable = newTaskAvailable;
    }

    @Override
    public void run() {
        while (!office.isEndOfDay()) {
            cabinDoor.lock();
            manager.addCurrentTask();
            manager.incrementTotalTask();
            System.out.println(Thread.currentThread().getName()+" Found new Task from Business");
            newTaskAvailable.signalAll();
            cabinDoor.unlock();
            try {
                /*Finding new tasks from business*/
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*Signalling no more work*/
        cabinDoor.lock();
        newTaskAvailable.signalAll();
        cabinDoor.unlock();
        System.out.println(Thread.currentThread().getName()+" Stops Working");
        System.out.println(Thread.currentThread().getName()+" Total Tasks given by manager :"+manager.getTotalTasksGiven());
        System.out.println(Thread.currentThread().getName()+" Total Tasks remaining in the list :"+manager.getCurrentTasks());


    }
}
