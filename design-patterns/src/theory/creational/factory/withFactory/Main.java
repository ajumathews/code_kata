package theory.creational.factory.withFactory;

/*
Here we can have two theory.creational.factory classes who have the responsibility for creating Shapes.

We can have multiple Factory classes with different behaviours of creating the shape.

 * */

public class Main {

    public static void main(String[] args) {
        ShapeFactory randomShapeFactory = new RandomShapeFactory();
        Shape randomShape = randomShapeFactory.getShape();
        randomShape.draw();


        ShapeFactory balancedShapeFactory = new RandomShapeFactory();
        Shape balancedShape = balancedShapeFactory.getShape();
        balancedShape.draw();

        ShapeFactoryByType shapeFactoryByType = new ShapeFactoryByType();
        Shape circle = shapeFactoryByType.getShape("circle");
        Shape rectangle = shapeFactoryByType.getShape("rectangle");

        circle.draw();
        rectangle.draw();

    }
}
