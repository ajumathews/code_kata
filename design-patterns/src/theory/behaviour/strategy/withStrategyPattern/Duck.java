package theory.behaviour.strategy.withStrategyPattern;

/*


*/

public class Duck {

    private QuackStrategy quackStrategy;
    private FlyStrategy flyStrategy;

    public Duck(QuackStrategy quackStrategy, FlyStrategy flyStrategy) {
        this.quackStrategy = quackStrategy;
        this.flyStrategy = flyStrategy;
    }

    public void performQuack(){
        quackStrategy.quack();
    }

    public void performFly(){
        flyStrategy.fly();
    }


}
