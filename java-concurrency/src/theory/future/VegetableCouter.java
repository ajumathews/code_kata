package theory.future;

import java.util.concurrent.Callable;

public class VegetableCouter implements Callable {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " Counting vegetables");
        Thread.sleep(5000);
        return 10;
    }
}
