package theory.nullObject.withNullObject;

/*
Here we can have two theory.creational.factory classes who have the responsibility for creating Shapes.

We can have multiple Factory classes with different behaviours of creating the shape.

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
