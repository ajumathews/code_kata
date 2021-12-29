package practice.basics;

import java.util.concurrent.*;

public class WithoutLambda {



    /*
    *
    * T1 = o1
    * T2 - o2
    * T3 -03
    * T4 -o4
    * T5 -05
    *
    *
    *
    *
    *
    *
    * */


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Employee aju = new Employee("Aju", 33, 1222212);

        Callable<String> c = new MyCallable(aju);
        ExecutorService e = Executors.newFixedThreadPool(5);
        for(int i =0; i<10; i++){
            Future<String> output = e.submit(c);
        }
        e.shutdown();
        System.out.println(aju.getName());
    }

}

