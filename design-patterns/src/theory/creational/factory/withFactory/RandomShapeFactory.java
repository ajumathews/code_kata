package theory.creational.factory.withFactory;

import java.util.Random;

public class RandomShapeFactory implements ShapeFactory {

    private Random rectangle;

    public RandomShapeFactory() {
        rectangle = new Random();
    }

    @Override
    public Shape getShape() {
        if (rectangle.nextBoolean()) {
            return new Rectangle();
        } else {
            return new Circle();
        }
    }
}
