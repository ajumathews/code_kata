package theory.behaviour.strategy.withoutStrategy;

public class CityDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("City Duck quacking");
    }

    @Override
    public void swim() {
        System.out.println("City Duck Swimming");
    }

    @Override
    public void fly() {
    }
}
