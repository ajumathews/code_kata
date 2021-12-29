package theory.behaviour.strategy.withStrategyPattern;

public class DefaultFlyStrategy implements FlyStrategy{

    @Override
    public void fly() {
        System.out.println("Default Flying");
    }
}
