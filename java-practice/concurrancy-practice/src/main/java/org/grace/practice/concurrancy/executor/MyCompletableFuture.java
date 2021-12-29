package org.grace.practice.concurrancy.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MyCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime= System.currentTimeMillis();

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(
                () -> {
                    try{
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e){

                    }
                    return 20;
                }

        ).thenApply(

                (Integer count) -> {
                    int transformedValue = count * 10;
                    //System.out.println("Took " + (System.currentTimeMillis()- startTime));
                    return transformedValue;
            }
        );



        System.out.println("Took " + (System.currentTimeMillis()- startTime));

        int count=completableFuture.get();
        System.out.println("Completable future took "+ (System.currentTimeMillis()- startTime));
        System.out.println(count);


    }

}
