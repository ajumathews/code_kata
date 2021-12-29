package theory.behaviour.iterator.withIterator;

public class TopicNameList implements List {

    private String[] topicNames;

    public TopicNameList(){
        topicNames = new String[10];
    }

    public String[] getTopicNames() {
        return topicNames;
    }

    public void setTopicNames(String[] topicNames) {
        this.topicNames = topicNames;
    }

    public Iterator iterator(){
        return new TopicNameIterator(this);
    }
}
