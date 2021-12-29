package theory.behaviour.template.withTemplate;

/*

Here save Method is a theory.behaviour.template method.
It calls the contents validate , pre and post methods before saving.
It has created a theory.behaviour.template for the Saving operation.

This pattern is widely used in frameworks where we need to overide few methods which will be called by the
framework before performing an operation

*/
public class Main {

    public static void main(String[] args) {
        Content image = new Image();
        Content video = new Video();

        SaveRecordToDB saveRecordToDB = new SaveRecordToDB();
        saveRecordToDB.save(image);
        saveRecordToDB.save(video);


    }

}
