package theory.behaviour.strategy.withStrategyPattern;

public class SpecialFlyStrategy implements FlyStrategy {

    @Override
    public void fly() {
        System.out.println("Special Flying abilities");
    }
}
