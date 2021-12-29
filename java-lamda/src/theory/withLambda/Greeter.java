package theory.withLambda;

/*

Type of the lamda expression - It can be of any Interface type which match the return type and arguments.
The name of the method doesnt matter. In this example we can see these lambdas can be assigned to any
Interface which have a method which matches the type of the lambda.

Now if we add a new method in the interface Test, now compiler will throw error, because it doesnt know
which method to pick.
A Functional interface should have only one method.


Also we can see we can call the perform method of the lambda expression.
Lambda expression looks like a shortcut of annonymous inner class, but they are not.


* */

public class Greeter {

    public static void greet(Greeting greeting) {

        greeting.perform();
    }

    public static void main(String[] args) {
        Greeting helloWorldGreeting = new HelloWorldGreeting();
        Greeting lambdaGreeting = () -> System.out.println("Helloworld from lambda");
        Test testGreeting = () -> System.out.println("Helloworld from Test");
        Greeting innerClassGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Inner class greeting");
            }
        };

        helloWorldGreeting.perform();
        lambdaGreeting.perform();
        testGreeting.foo();
        innerClassGreeting.perform();

    }
}


interface Test {
    void foo();
/*
    void print();
    int mul();
    */
}