package theory.synchronization.producerConsumer;

import java.util.concurrent.BlockingQueue;

public class Manager implements Runnable {

    private BlockingQueue<String> taskQueue;

    public Manager(BlockingQueue<String> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            taskQueue.add("Task " + i);
            System.out.println("Manager Added Task");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 3; i++) {
            taskQueue.add("Stop");
        }
    }
}
