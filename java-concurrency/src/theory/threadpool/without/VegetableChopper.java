package theory.threadpool.without;

public class VegetableChopper implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Chopping vegetables");
    }
}
