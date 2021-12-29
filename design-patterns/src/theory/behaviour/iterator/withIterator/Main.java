package theory.behaviour.iterator.withIterator;
/*

Here there is a standard way to iterate. The client code need not worry about the iteration logic.
It should be taken care by the Class and its theory.behaviour.iterator.


* */


public class Main {

    public static void main(String[] args) {
        String[] topicNameArray = {"java", "python"};
        int[] topicIdArray = {2, 3};

        System.out.println("Created Topic Name List");
        TopicNameList topicNameList = new TopicNameList();
        topicNameList.setTopicNames(topicNameArray);

        System.out.println("Created Topic Id List");
        TopicIdList topicIdList = new TopicIdList();
        topicIdList.setTopicIds(topicIdArray);

        System.out.println("Iterate Topic Ids");
        Iterator topicIdIterator= topicIdList.iterator();
        while(topicIdIterator.hasNext()){
            System.out.println(topicIdIterator.next());
        }

        System.out.println("Iterate Topic Names");
        Iterator topicNameIterator= topicNameList.iterator();
        while(topicNameIterator.hasNext()){
            System.out.println(topicNameIterator.next());
        }

    }
}
