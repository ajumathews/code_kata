package theory.nullObject.withoutNullObject;

public class ShapeFactoryByType {

    public Shape getShape(String shapeType) {
        switch (shapeType) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            default:
                return null;
        }

    }
}
