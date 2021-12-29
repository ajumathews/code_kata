package theory.behaviour.iterator.withIterator;

public class TopicIdList implements List {

    private int[] topicIds;

    public TopicIdList() {
        topicIds = new int[10];
    }

    public int[] getTopicIds() {
        return topicIds;
    }

    public void setTopicIds(int[] topicIds) {
        this.topicIds = topicIds;
    }

    public TopicIdIterator iterator(){
        return  new TopicIdIterator(this);
    }
}
