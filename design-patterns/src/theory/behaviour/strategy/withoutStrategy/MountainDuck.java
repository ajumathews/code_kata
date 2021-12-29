package theory.behaviour.strategy.withoutStrategy;

public class MountainDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Mountain Duck Quaking");
    }

    @Override
    public void swim() {
        System.out.println("Mountain Duck Swimming");
    }

    @Override
    public void fly() {
        System.out.println("Mountain Duck Flying");
    }
}
