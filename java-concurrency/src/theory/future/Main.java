package theory.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
Here we use Future object to get the result back from an async operation
* */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("Main Thread calling vegetable Counter thread");
        Future result = executorService.submit(new VegetableCouter());
        System.out.println("Main Thread doing other tasks");
        System.out.println("Vegetables : " + result.get());
        executorService.shutdown();
    }
}
