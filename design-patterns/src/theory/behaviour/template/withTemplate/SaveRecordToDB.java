package theory.behaviour.template.withTemplate;

public class SaveRecordToDB {

    public void save(Content content) {
        content.validate();
        content.preSave();
        System.out.println("Save content to DB");
        content.postSave();
    }


}
