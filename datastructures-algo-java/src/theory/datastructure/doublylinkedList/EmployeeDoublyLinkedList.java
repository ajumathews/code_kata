package theory.datastructure.doublylinkedList;

import theory.datastructure.model.Employee;

public class EmployeeDoublyLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void addToFront(Employee e) {
        EmployeeNode currentNode = new EmployeeNode(e);
        currentNode.setNext(head);
        if (head != null) {
            head.setPrevious(currentNode);
        }
        head = currentNode;
        if (tail == null) {
            tail = currentNode;
        }
        size++;
    }

    public void addToLast(Employee e) {
        EmployeeNode currentNode = new EmployeeNode(e);
        currentNode.setPrevious(tail);
        if (tail != null) {
            tail.setNext(currentNode);
        }
        tail = currentNode;
        if (head == null) {
            head = currentNode;
        }
        size++;
    }

    public boolean removeFromFront() {
        if (head != null) {
            EmployeeNode nodeToRemove = head;
            head = nodeToRemove.getNext();
            if(head==null) {
                tail=null;
            }else{
                head.setPrevious(null);
            }
            nodeToRemove.setNext(null);
            size--;
            return true;
        }
        return false;
    }

    public boolean removeFromLast() {
        if (tail != null) {
            EmployeeNode nodeToRemove = tail;
            tail = nodeToRemove.getPrevious();
            if (tail == null) {
                head=null;
            }else{
                tail.setNext(null);
            }
            nodeToRemove.setPrevious(null);
            size--;
            return true;
        }
        return false;
    }


    public void printElements() {
        EmployeeNode currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getEmployee().toString());
            currentNode = currentNode.getNext();
        }
    }


    public int getSize() {
        return size;
    }
}
