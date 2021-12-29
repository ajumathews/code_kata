package theory.creational.factory.withFactory;

public class BalancedShapeFactory implements ShapeFactory {

    boolean rectangleCreated;

    @Override
    public Shape getShape() {
        if (rectangleCreated) {
            rectangleCreated = false;
            return new Circle();
        } else {
            rectangleCreated = true;
            return new Rectangle();
        }
    }
}
