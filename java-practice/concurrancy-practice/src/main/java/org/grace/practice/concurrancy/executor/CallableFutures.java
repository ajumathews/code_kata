package org.grace.practice.concurrancy.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableFutures {

    public static void main(String[] args) throws InterruptedException{

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Long>> futures = new ArrayList<>();

        for(int i=0;i<10; i++){

            Callable worker = new MyCallable();
            Future future=executor.submit(worker);
            futures.add(future);
        }

        long sum=0;

        for(Future<Long> future: futures){
            try{
                sum+=future.get();
            }
            catch (InterruptedException e){

            }catch (ExecutionException e){}
        }

        System.out.println(sum);
        executor.shutdown();
    }
}
