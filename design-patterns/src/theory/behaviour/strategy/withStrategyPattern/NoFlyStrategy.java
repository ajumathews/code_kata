package theory.behaviour.strategy.withStrategyPattern;

public class NoFlyStrategy implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("No Flying theory.behaviour");
    }
}
