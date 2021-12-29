package theory.datastructure.linkedList;

import theory.datastructure.model.Employee;

public class EmployeeLinkedList {

    private EmployeeNode head;
    private int size;

    /*O(1)*/
    public void addToFront(Employee e) {
        EmployeeNode currentNode = new EmployeeNode(e);
        currentNode.setNext(head);
        head = currentNode;
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    /*O(1)*/
    public EmployeeNode removeElementFromFront() {
        EmployeeNode currentNode = head;
        head = currentNode.getNext();
        currentNode.setNext(null);
        size--;
        return currentNode;
    }

    public void printListElements() {
        EmployeeNode currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getEmployee().toString());
            currentNode = currentNode.getNext();
        }
    }


}
