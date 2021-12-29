package theory.threadpool.with;

public class VegetableChopper implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Chopping vegetables");
    }
}
