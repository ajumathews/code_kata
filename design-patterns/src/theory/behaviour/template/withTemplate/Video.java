package theory.behaviour.template.withTemplate;

public class Video implements Content {
    private String videoFormat;

    @Override
    public boolean validate() {
        System.out.println("check if video is a valid format");
        return true;
    }

    @Override
    public void preSave() {
        System.out.println("Compress the video");

    }

    @Override
    public void postSave() {

    }
}
