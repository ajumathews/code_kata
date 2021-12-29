package theory.behaviour.iterator.withoutIterator;

public class TopicNameList {

    private String[] topics;

    public TopicNameList(){
        topics = new String[10];
    }

    public String[] getTopics() {
        return topics;
    }

    public void setTopics(String[] topics) {
        this.topics = topics;
    }
}
