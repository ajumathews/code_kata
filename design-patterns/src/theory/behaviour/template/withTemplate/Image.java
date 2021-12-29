package theory.behaviour.template.withTemplate;

public class Image implements Content {
    private String imageFormat;

    @Override
    public boolean validate() {
        System.out.println("check if image is a valid format");
        return true;
    }

    @Override
    public void preSave() {
        System.out.println("Compress the image");
    }

    @Override
    public void postSave() {

    }
}
