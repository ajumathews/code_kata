package theory.datastructure.queue;

import theory.datastructure.model.Employee;

import java.util.Iterator;
import java.util.LinkedList;

public class EmployeeLinkedQueue {

    private LinkedList<Employee> queue;

    public EmployeeLinkedQueue() {
        queue = new LinkedList<>();
    }

    public void add(Employee e) {
        queue.add(e);
    }

    public Employee remove() {
        return queue.remove();
    }

    public Employee peek() {
        return queue.peek();
    }

    public void printQueue() {
        Iterator<Employee> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
