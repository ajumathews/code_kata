package theory.creational.singleton.withSingleton;

/*
Imagine we want to have only one instance of the calculator throughout the runtime of the application
Then we cant achieve that.

* */

public class Main {

    public static void main(String[] args) {
        Calculator c1 = Calculator.getInstance();
        Calculator c2 = Calculator.getInstance();
        System.out.println(c1 == c2);
    }
}
