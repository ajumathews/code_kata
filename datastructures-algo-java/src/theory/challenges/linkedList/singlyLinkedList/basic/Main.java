package theory.challenges.linkedList.singlyLinkedList.basic;

public class Main {

    public static void main(String[] args) {

        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addToTheHead("babu");
        linkedList.addToTheHead("pavan");
        linkedList.addToTheHead("aju");
        linkedList.printElements();

        System.out.println("---Adding Kaveri---");
        linkedList.addToTheHead("kaveri");
        linkedList.printElements();

        System.out.println("---Removing the head---");
        linkedList.removeElementFromHead();
        linkedList.printElements();

        System.out.println("---Checking for element head---");
        System.out.println(linkedList.containsElement("aju"));
        System.out.println(linkedList.containsElement("anju"));

        System.out.println("---Getting size--");
        System.out.println(linkedList.getSize());

        System.out.println("---Removing element--");
        System.out.println(linkedList.removeNodeWithValue("pavan"));
        linkedList.printElements();

        System.out.println("---Getting size--");
        System.out.println(linkedList.getSize());


        System.out.println("---Getting Element from Head--");
        System.out.println(linkedList.getElementFromHead());

        System.out.println("---Getting size--");
        System.out.println(linkedList.getSize());
        linkedList.printElements();

    }
}
