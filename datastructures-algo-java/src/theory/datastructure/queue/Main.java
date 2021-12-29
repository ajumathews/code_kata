package theory.datastructure.queue;

import theory.datastructure.model.Employee;

public class Main {

    public static void main(String[] args) {
        Employee aju = new Employee("Aju",31);
        Employee babu= new Employee("Babu",31);
        Employee pavan = new Employee("Pavan",31);

        EmployeeArrayQueue arrayQueue = new EmployeeArrayQueue(5);

        System.out.println("Add");
        arrayQueue.add(aju);
        arrayQueue.add(babu);
        arrayQueue.add(pavan);
        arrayQueue.printQueue();

        System.out.println("Add");
        arrayQueue.remove();
        arrayQueue.remove();
        arrayQueue.printQueue();

        System.out.println("Peek");
        arrayQueue.peek();
        arrayQueue.add(aju);
        arrayQueue.add(babu);
        arrayQueue.printQueue();

        arrayQueue.remove();
        arrayQueue.add(aju);
        arrayQueue.add(babu);

        arrayQueue.remove();
        arrayQueue.add(babu);


    }
}
