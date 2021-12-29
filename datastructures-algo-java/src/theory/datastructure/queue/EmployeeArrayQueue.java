package theory.datastructure.queue;

import theory.datastructure.model.Employee;

import java.util.NoSuchElementException;

public class EmployeeArrayQueue {

    private Employee[] queue;
    private int first;
    private int last;


    public EmployeeArrayQueue(int intialCapacity) {
        this.queue = new Employee[intialCapacity];
    }

    public void add(Employee e) {
        if (last == queue.length) {
            /*Resize*/
            Employee[] newArray = new Employee[queue.length * 2];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }
        queue[last] = e;
        last++;
    }

    public Employee remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        Employee employee = queue[first];
        queue[first] = null;
        first++;
        if (size() == 0) {
            first = 0;
            last = 0;
        }
        return employee;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return queue[first];
    }

    public void printQueue() {
        for (int i = first; i < last; i++) {
            System.out.println(queue[i].toString());
        }
    }

    public int size() {
        return last - first;
    }


}
