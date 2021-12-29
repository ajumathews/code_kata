package practice.basic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        new Thread(new Manager(queue)).start();
        new Thread(new Worker(queue)).start();
        new Thread(new Worker(queue)).start();

    }


}


class Manager implements Runnable{
    private BlockingQueue<String> queue;

    public Manager(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i =0;i<10;i ++){
            queue.add("hello" +i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Worker implements Runnable{
    private BlockingQueue<String> queue;

    public Worker(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i =0;i<10;i ++){
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}