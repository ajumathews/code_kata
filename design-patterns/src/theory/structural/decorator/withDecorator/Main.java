package theory.structural.decorator.withDecorator;

/*

Here we have created AddonBeverages which has a Beverage instance using which we modify the cost method.

We can just wrap the object around other theory.structural.decorator and pass it on to other decorater and so on.
This leads to very flexible design without class Explosion or multiple boolean expressions

eg: InputStream in java
* */

public class Main {

    public static void main(String[] args) {
        Beverage cappucino = new Cappucino();
        System.out.println(cappucino.cost());

        Beverage expresso= new Expresso();
        System.out.println(expresso.cost());

        Beverage cappucinoWithChocalate = new ChocolateAddon(new Cappucino());
        System.out.println(cappucinoWithChocalate.cost());

        Beverage expressoWithChocalateAndSoy = new SoyMilkAddon(new ChocolateAddon(new Expresso()));
        System.out.println(expressoWithChocalateAndSoy.cost());
    }
}
