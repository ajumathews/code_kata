package theory.behaviour.strategy.withStrategyPattern;

public class DefaultQuackStrategy implements QuackStrategy {
    @Override
    public void quack() {
        System.out.println("Default Quack");
    }
}
