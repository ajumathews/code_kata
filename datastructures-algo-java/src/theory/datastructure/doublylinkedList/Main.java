package theory.datastructure.doublylinkedList;

import theory.datastructure.model.Employee;

public class Main {

    public static void main(String[] args) {

        Employee aju = new Employee("Aju",31);
        Employee babu= new Employee("Babu",31);
        Employee pavan = new Employee("Pavan",31);

        EmployeeDoublyLinkedList doublyLinkedList = new EmployeeDoublyLinkedList();
        doublyLinkedList.addToFront(aju);
        doublyLinkedList.addToFront(babu);
        doublyLinkedList.addToFront(pavan);


        Employee sarin= new Employee("Sarin", 31);
        doublyLinkedList.addToLast(sarin);
        doublyLinkedList.printElements();
        System.out.println(doublyLinkedList.getSize());

        boolean removalStatus =doublyLinkedList.removeFromFront();
        System.out.println("Removed from Front:"+removalStatus);
        doublyLinkedList.printElements();

        removalStatus=doublyLinkedList.removeFromLast();
        System.out.println("Removed from Last:"+removalStatus);
        doublyLinkedList.printElements();


        removalStatus=doublyLinkedList.removeFromLast();
        System.out.println("Removed from Last:"+removalStatus);


        removalStatus=doublyLinkedList.removeFromLast();
        System.out.println("Removed from Last:"+removalStatus);

        doublyLinkedList.printElements();
        doublyLinkedList.addToFront(sarin);
        doublyLinkedList.printElements();

        removalStatus=doublyLinkedList.removeFromFront();
        System.out.println("Removed from Last:"+removalStatus);
        doublyLinkedList.printElements();

    }
}
