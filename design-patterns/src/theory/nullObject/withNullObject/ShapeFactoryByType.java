package theory.nullObject.withNullObject;

public class ShapeFactoryByType {

    public Shape getShape(String shapeType) {
        switch (shapeType) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            default:
                return new NullShape();
        }

    }
}
