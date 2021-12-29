package theory.structural.bridge.withBridge;

public class ThumbNailView implements View {

    private Resource resource;

    public ThumbNailView(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void show() {
        System.out.println("ThumbNail Screen View");
        System.out.println(resource.getImage());
    }
}
