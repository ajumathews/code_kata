package theory.structural.bridge.withBridge;

public class FullScreenView implements View {

    private Resource resource;

    public FullScreenView(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void show() {
        System.out.println("Full Screen View");
        System.out.println(resource.getImage());
        System.out.println(resource.getTitle());
    }
}
