package practice.basics;

public class MyRunnable implements Runnable{

    private Employee e;

    public MyRunnable() {
    }

    public MyRunnable(Employee e) {
        this.e = e;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        e.setName(e.getName().toLowerCase());
    }
}
