package theory.withoutLambda;

/*
In the first method we are printing a helloWorld.

If we want to have a method which print greetings dynamically, then we pass an interface to the method.
and it calls the perform method.

Now if you see the greet method, we are not passing a behaviour, we are passing a class which has the behaviour
This is not something which java 7 provides.

Lambdas does just that where we can pass functions which do not belong to a classs, they are functions which exists in
isolation. these functions can be treated as values.

* */

public class Greeter {


    public void greetSimple(){
        System.out.println("Hello World");
    }

    public void greet(Greeting greeting) {
        greeting.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        Greeting greeting = new HelloWorldGreeting();
        greeter.greet(greeting);
    }
}
