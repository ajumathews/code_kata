package theory.withLambda;


public class HelloWorldGreeting implements Greeting {
    @Override
    public void perform() {
        System.out.println("hello World");
    }
}
