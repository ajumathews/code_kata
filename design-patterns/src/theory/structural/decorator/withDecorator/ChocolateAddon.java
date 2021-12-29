package theory.structural.decorator.withDecorator;

public class ChocolateAddon implements Beverage {

    private Beverage beverage;

    public ChocolateAddon(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return beverage.cost() + 3;
    }
}
