package liskovSubstitution.without;

public class WildDuck implements Duck {
    @Override
    public void swim() {
        System.out.println("Swimming");
    }
}
