package theory.challenges.linkedList.doublyLinkedList.construction;

public class DoublyLinkedList {

    public Node head;
    public Node tail;

    public void setHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void setTail(Node node) {
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }

    public void insertBefore(Node node, Node nodeToInsert) {
        remove(nodeToInsert);
        nodeToInsert.next = node;
        nodeToInsert.prev = node.prev;
        node.prev = nodeToInsert;

        if (nodeToInsert.prev == null) {
            head = nodeToInsert;
        } else {
            nodeToInsert.prev.next = nodeToInsert;
        }
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        remove(nodeToInsert);
        nodeToInsert.prev = node;
        nodeToInsert.next = node.next;
        node.next = nodeToInsert;

        if (nodeToInsert.next == null) {
            tail = nodeToInsert;
        } else {
            nodeToInsert.next.prev = nodeToInsert;
        }


    }


    public void insertAtPosition(int position, Node nodeToInsert) {
        remove(nodeToInsert);
        if (position == 1) {
            setHead(nodeToInsert);
            return;
        }
        Node positionToInsertAfter = head;

        int currentPosition = 2;
        while (currentPosition != position && positionToInsertAfter != null) {
            currentPosition++;
            positionToInsertAfter = positionToInsertAfter.next;
        }
        if (positionToInsertAfter == null) {
            setTail(nodeToInsert);
        } else {
            insertAfter(positionToInsertAfter, nodeToInsert);
        }
    }

    public void removeNodesWithValue(int value) {
        Node node = head;
        while (node != null) {
            Node nodeToRemove = node;
            node = node.next;
            if (value == nodeToRemove.value) {
                remove(nodeToRemove);

            }
        }

    }

    public void remove(Node node) {
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = null;

    }

    public boolean containsNodeWithValue(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;


    }

}
