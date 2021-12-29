package theory.synchronization.producerConsumer;

import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable {

    private BlockingQueue<String> taskQueue;

    public Worker(BlockingQueue<String> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String task = taskQueue.take();
                if (task.equals("Stop")) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " got " + task);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
