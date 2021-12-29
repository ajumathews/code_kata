package theory.structural.decorator.withDecorator;

public class SoyMilkAddon implements Beverage {

    private Beverage beverage;

    public SoyMilkAddon(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return beverage.cost() + 2;
    }
}
