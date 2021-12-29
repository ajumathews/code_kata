package theory.synchronization.without;

import java.util.concurrent.locks.Lock;

public class TaskFinder implements Runnable {

    private Manager manager;
    private Lock cabinDoor;
    private Office office;

    public TaskFinder(Manager manager, Lock cabinDoor, Office office) {
        this.manager = manager;
        this.cabinDoor = cabinDoor;
        this.office = office;
    }

    @Override
    public void run() {
        while (!office.isEndOfDay()) {
            cabinDoor.lock();
            manager.addCurrentTask();
            manager.incrementTotalTasksGiven();
            System.out.println(Thread.currentThread().getName()+" Found new Task from Business");
            cabinDoor.unlock();

            try {
                /*Finding new tasks from business*/
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" Stops Working");
        System.out.println(Thread.currentThread().getName()+" Total Tasks found by manager :"+manager.getTotalTasksGiven());
        System.out.println(Thread.currentThread().getName()+" Total Tasks remaining in the list :"+manager.getCurrentTasks());

    }
}
