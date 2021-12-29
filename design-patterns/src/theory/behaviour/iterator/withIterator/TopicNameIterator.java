package theory.behaviour.iterator.withIterator;

public class TopicNameIterator implements Iterator {

    private String[] topicNames;
    private int lastIndex;

    public TopicNameIterator(TopicNameList topicNameList) {
        topicNames = new String[topicNameList.getTopicNames().length];
        System.arraycopy(topicNameList.getTopicNames(), 0, topicNames, 0, topicNameList.getTopicNames().length);
    }

    @Override
    public boolean hasNext() {
        if (lastIndex < topicNames.length)
            return true;
        return false;
    }

    @Override
    public String next() {
        String topicName = topicNames[lastIndex];
        lastIndex++;
        return topicName;
    }
}
