package theory.nullObject.withoutNullObject;

/*

In our code we encounter a lot of null.
The idea is to avoid comparison by polymorphism.

In this code, we get a null.
 * */

public class Main {

    public static void main(String[] args) {

        ShapeFactoryByType shapeFactoryByType = new ShapeFactoryByType();
        Shape circle = shapeFactoryByType.getShape("circle");
        Shape rectangle = shapeFactoryByType.getShape("rectangle");
        Shape nullObject = shapeFactoryByType.getShape("invalid");

        circle.draw();
        rectangle.draw();
        nullObject.draw();
    }
}
