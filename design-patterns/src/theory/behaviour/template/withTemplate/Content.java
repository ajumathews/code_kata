package theory.behaviour.template.withTemplate;

public interface Content {
    boolean validate();
    void preSave();
    void postSave();
}
