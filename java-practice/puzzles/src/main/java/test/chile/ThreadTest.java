package test.chile;

public class ThreadTest extends Thread {

    ThreadTest(){}

    ThreadTest(Runnable r){
        super(r);
    }

    @Override
    public void run() {
        System.out.println("Inside THread");
    }
}


class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Inside Runnanle");
    }
}

class Test1{
    public static void main(String[] args) {
        new ThreadTest().start();
        new ThreadTest(new MyRunnable()).start();
    }
}