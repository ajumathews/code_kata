package theory.behaviour.strategy.withoutStrategy;

public class PolarDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("PolarDuck Duck Quaking");
    }

    @Override
    public void swim() {
        System.out.println("PolarDuck Duck Swimming");
    }

    @Override
    public void fly() {
        System.out.println("PolarDuck Duck Flying");
    }
}
