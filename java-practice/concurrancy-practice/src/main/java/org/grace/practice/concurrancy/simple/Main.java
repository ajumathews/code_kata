package org.grace.practice.concurrancy.simple;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList();

        for(int i=0;i<500; i++){
            Runnable task = new MyRunnable(10000);
            Thread worker = new Thread(task);
            worker.setName(String.valueOf(i));
            worker.start();
            threads.add(worker);
        }

        int running=0;
        do{
            running=0;
            for (Thread thread:threads){
                 if(thread.isAlive()){
                    running++;
                }
            }
            System.out.println("No of running threadds "+ running);
        }
        while (running>0);
    }
}
