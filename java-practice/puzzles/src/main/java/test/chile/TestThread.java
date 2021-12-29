package test.chile;

public class TestThread implements Runnable {

    @Override
    public void run() {
        System.out.println("run");
    }
}

class Myclass{
    public static void main(String[] args) {
        Thread t1 = new Thread();
        t1.start();
        System.out.println("Main");
    }

}
