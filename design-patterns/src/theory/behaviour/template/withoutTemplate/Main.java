package theory.behaviour.template.withoutTemplate;

/*
Imagine a Class which saves the images and videos to DB.
We have to do a set of pre and post operations before saving which is specific to each Component.

Here the Save method has to do all these validations before insertions.
But the real intention of the save method is to only save data to DB.
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
