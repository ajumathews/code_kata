package test.chile;

public class Mythread extends  Thread {

    Mythread(){

        System.out.println("MyThread");
    }

    @Override
    public void run() {
        System.out.println("World");
    }

    public void run(String s){
        System.out.println(" RUn");
    }

}


class TestTHreads{

    public static void main(String[] args) {
        Thread t = new Mythread(){

            public void run(){
                System.out.println("Hello");
            }

        };
        t.start();
    }
}

