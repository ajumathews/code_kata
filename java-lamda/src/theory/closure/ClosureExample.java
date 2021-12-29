package theory.closure;

import java.util.function.Consumer;

/*
In the add Lambda we are using the variable b.
So within the lambdas, we cant change the variable value of b - those are effectively final

This is called as Closure, where the value of b is frozen.

* */
public class ClosureExample {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        //b++; variables used within lambdas are effectively final
        Consumer<Integer> add = (i)-> {
            //b=20;  variables used within lambdas are effectively final
            System.out.println(i+b);
        };

        add.accept(10);

        add.accept(10);


    }



}
