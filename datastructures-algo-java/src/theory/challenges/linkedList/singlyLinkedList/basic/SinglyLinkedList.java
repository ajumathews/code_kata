package theory.challenges.linkedList.singlyLinkedList.basic;

public class SinglyLinkedList {

    private Node head;
    private int size;

    public void addToTheHead(String value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public String getElementFromHead() {
        if (head != null) {
            return head.value;
        }
        return null;
    }

    public void removeElementFromHead() {
        if (head != null) {
            Node currentHead = head;
            head = currentHead.next;
            currentHead.next = null;
            size--;
        }
    }

    public boolean containsElement(String input) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value.equals(input)) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    public boolean removeNodeWithValue(String input) {
        Node currentNode = head; //10
        Node previousVistedNode = null;
        while (currentNode != null) {
            if (currentNode.value.equals(input)) {
                previousVistedNode.next = currentNode.next;
                currentNode.next = null;
                size--;
                return true;
            } else {
                previousVistedNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        return false;
    }


    public int getSize() {
        return size;
    }

    public void printElements() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }

}
