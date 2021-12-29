package theory.withLambda;

@FunctionalInterface
public interface Greeting {
    void perform();
/*  this will throw compile error
    void add();
*/
}
