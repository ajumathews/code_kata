package theory.datastructure.queue;

import theory.datastructure.model.Employee;

public class MainLinkedQueue {

    public static void main(String[] args) {
        Employee aju = new Employee("Aju", 31);
        Employee babu = new Employee("Babu", 31);
        Employee pavan = new Employee("Pavan", 31);

        EmployeeLinkedQueue linkedQueue = new EmployeeLinkedQueue();

        System.out.println("Add");
        linkedQueue.add(aju);
        linkedQueue.add(babu);
        linkedQueue.add(pavan);
        linkedQueue.printQueue();

        System.out.println("Remove");
        linkedQueue.remove();
        linkedQueue.printQueue();

        System.out.println("Peek");
        linkedQueue.peek();
        linkedQueue.printQueue();
    }
}


