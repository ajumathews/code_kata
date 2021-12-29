package theory.behaviour.strategy.withStrategyPattern;

public class MainClass {

    public static void main(String[] args) {

        Duck wildDuck= new Duck(new DefaultQuackStrategy(),new NoFlyStrategy());
        Duck cityDuck = new Duck(new DefaultQuackStrategy(),new NoFlyStrategy());
        Duck MountainDuck = new Duck(new DefaultQuackStrategy(), new DefaultFlyStrategy());
        Duck rubberDuck = new Duck(new NoQuackStrategy(),new NoFlyStrategy());
        Duck cloudDuck = new Duck(new DefaultQuackStrategy(),new SpecialFlyStrategy());

        wildDuck.performFly();
    }
}
