package test.chile;

import java.util.PriorityQueue;

public class Test implements  Runnable {


    @Override
    public void run() {
        System.out.println("hello");
    }

    public static void main(String[] args) {

        PriorityQueue p = new PriorityQueue();
        p.add(11);
        p.add(10);
        p.add(22);
        p.add(5);
        p.add(12);
        p.add(2);

        while(!p.isEmpty()){
            System.out.println(p.remove());
        }


    }
}
