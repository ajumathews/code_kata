package theory.behaviour.strategy.withStrategyPattern;

public class NoQuackStrategy implements QuackStrategy {
    @Override
    public void quack() {
        System.out.println("No Quacking");
    }
}
