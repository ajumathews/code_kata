package theory.behaviour.iterator.withIterator;

public class TopicIdIterator implements Iterator {

    private int[] topicIds;
    private int lastIndex;

    public TopicIdIterator(TopicIdList topicIdList) {
        topicIds= new int[topicIdList.getTopicIds().length];
        System.arraycopy(topicIdList.getTopicIds(), 0, topicIds, 0, topicIdList.getTopicIds().length);
    }

    @Override
    public boolean hasNext() {
        if (lastIndex < topicIds.length)
            return true;
        return false;
    }

    @Override
    public Integer next() {
        Integer i = topicIds[lastIndex];
        lastIndex++;
        return i;
    }
}
