package theory.structural.bridge.withBridge;

public class AlbumResource implements Resource {
    @Override
    public String getTitle() {
        return "Album Title";
    }

    @Override
    public String getImage() {
        return "Album Image";
    }
}
