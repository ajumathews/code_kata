package liskovSubstitution.with;

/*
Now Swimming behaviour is moved to an interface. So we can easily specify the behaviours
* */

public class Duck {
    SwimmingBehavior swimmingBehavior;

    public void swim(){
        swimmingBehavior.swim();
    }
}
