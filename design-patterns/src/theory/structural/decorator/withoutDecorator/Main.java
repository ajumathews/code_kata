package theory.structural.decorator.withoutDecorator;

/*

Here if we want to do some Addon to the Beverage . eg - if we want to add Chocolate or soy milk to the Beverage
It should reflect in the cost.

Two ways of doing that
 - We create boolean variables in the implementors to check for chocolate added or soy milk added
then while calculating the cost we check this.

- We can create new classes like ExpressoWithChocolate , ExpressoWithSoy etc with the cost method updated.



Decorator pattern addresses this use case.

* */

public class Main {

    public static void main(String[] args) {
        Beverage cappucino = new Cappucino();
        System.out.println(cappucino.cost());

        Beverage expresso= new Expresso();
        System.out.println(expresso.cost());
    }
}
