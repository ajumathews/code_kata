package theory.creational.factory.withoutFactory;

/*

If I want to create a set of shape objects. I have to do it in the client code.

Imagine a game where we want to create random Shapes. We have to do it at client code.

If i want to create a set of equal Number of shape objects also i have to do it from client code

Factory pattern is suited for this creation scenarios.


* */

public class Main {

    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Shape circle = new Circle();
        rectangle.draw();
        circle.draw();
    }
}
