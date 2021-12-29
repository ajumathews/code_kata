package practice.basics;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

    private Employee e;

    public MyCallable(Employee e) {
        this.e = e;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return e.getName().toLowerCase();
    }
}
