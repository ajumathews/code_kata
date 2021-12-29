package theory.behaviour.iterator.withoutIterator;
/*

Here there is no Standard way of iterating. The client class have to do the iteration by itself.

* */


public class Main {

    public static void main(String[] args) {
        String[] topicNameArray = {"java", "python"};
        int[] topicIdArray = {2, 3};

        System.out.println("Created Topic Name List");
        TopicNameList topicNameList = new TopicNameList();
        topicNameList.setTopics(topicNameArray);

        System.out.println("Created Topic Id List");
        TopicIdList topicIdList = new TopicIdList();
        topicIdList.setTopicIds(topicIdArray);

        System.out.println("Iterate Topic Names");
        for(String topicName: topicNameList.getTopics()){
            System.out.println(topicName);
        }

        System.out.println("Iterate Topic Ids");
        for(int topicId: topicIdList.getTopicIds()){
            System.out.println(topicId);
        }
    }
}
