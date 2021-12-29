package org.grace.practice.concurrancy.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorCallableFuture {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(
                ()->{
                    try{
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e){

                    }
                    return 20;
                }


        ,executor).thenApply(
                (Integer count) ->{
                    return  10*count;
                }
        );




    }
}
