package theory.behaviour.template.withoutTemplate;

public class SaveRecordToDB {

    public void save(Content content) {
        if (content instanceof Video) {
            System.out.println("check if video is a valid format");
            System.out.println("Compress the video");
        } else if (content instanceof Image) {
            System.out.println("check if image is a valid format");
            System.out.println("Compress the image");
        }

        System.out.println("Save content to DB");
    }


}
