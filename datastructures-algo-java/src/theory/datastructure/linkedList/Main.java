package theory.datastructure.linkedList;

import theory.datastructure.model.Employee;

public class Main {

    public static void main(String[] args) {

        Employee aju = new Employee("Aju",31);
        Employee babu= new Employee("Babu",31);
        Employee pavan = new Employee("Pavan",31);

        EmployeeLinkedList linkedList = new EmployeeLinkedList();
        linkedList.addToFront(aju);
        linkedList.addToFront(babu);
        linkedList.addToFront(pavan);

        System.out.println(linkedList.getSize());
        linkedList.removeElementFromFront();
        System.out.println(linkedList.getSize());

        linkedList.printListElements();

    }
}
