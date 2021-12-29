package theory.threadpool.without;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Here we created a theory.threadpool with the number of threads as per the number of cores.
*/
public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 100; i++) {
            executorService.submit(new VegetableChopper());
        }
        executorService.shutdown();
    }
}
