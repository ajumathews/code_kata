package theory.behaviour.strategy.withoutStrategy;

public class WildDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Wild Duck Quacking");
    }

    @Override
    public void swim() {
        System.out.println("Wild Duck Swimming");
    }

    @Override
    public void fly() {

    }
}
