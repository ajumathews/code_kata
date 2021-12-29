package org.grace.practice.concurrancy.executor;

import org.grace.practice.concurrancy.simple.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainExecutorThread {

    public static void main(String[] args) throws InterruptedException{
    ExecutorService executor = Executors.newFixedThreadPool(10);
    for(int i=0;i<500;i++){
        Runnable worker = new MyRunnable(100000000);
        executor.execute(worker);
    }
    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.SECONDS);
    System.out.println("Excuted all threads");

}
}

