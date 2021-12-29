package openclosed.without;

/*

Here CoffeeMobileApp is bound to the BasicCoffeeMachine.
Imagine if we want to use a new Advanced Coffee machine . Then we should be able to do that easily.
*/

public class CoffeeMobileApp {

    private BasicCoffeeMachine coffeeMachine;

    public void makeCoffee(){
        coffeeMachine.makeCoffee();
    }
}
