package theory.behaviour.strategy.withoutStrategy;

/*

If we have a common Duck interface with All the behaviours then it leads to multiple problems when
dealing with different implementations.

For eg:
-Rubber Duck has to simply override all the methods with empty implementation.
-WildDuck and CityDuck has to simply override the fly method with empty implementation.
-PolarDuck and MountainDuck have a common fly theory.behaviour.
 We cannot reuse that piece of code , instead we have to write it twice.
*/


public class MainClass {

    public static void main(String[] args) {
        Duck wildDuck = new WildDuck();
        Duck cityDuck = new CityDuck();
        Duck mountainDuck = new MountainDuck();
        Duck polarDuck = new PolarDuck();
        Duck RubberDuck = new RubberDuck();
    }
}
