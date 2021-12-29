package theory.collection;

import org.junit.Test;
import theory.stream.Employee;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeListIteration {

    Employee e1 = new Employee("aju", "123");
    Employee e2 = new Employee("kaveri", "123");
    Employee e3 = new Employee("akshatha", "123");

    @Test
    public void testArrayListFailSafe() {
        List<Employee> empList = new CopyOnWriteArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);

        // it will not throw concurrentModificationException .We are iterating on a snapshot of the collection
        empList.forEach((e) -> {
            System.out.println(e.getName());
            empList.remove(e);
        });

        System.out.println(empList.size());

    }

    @Test(expected = UnsupportedOperationException.class)
    public void testArrayListFailSafeRemove() {
        List<Employee> empList = new CopyOnWriteArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);

        // it will throw unsupportedOperation since CopyOnWriteArrayList is for safe iterating
        Iterator<Employee> itr = empList.iterator();
        while (itr.hasNext()) {
            Employee e = itr.next();
            System.out.println(e.getName());
            itr.remove();
        }

        // All elements are removed
        System.out.println(empList.size());


    }


    @Test
    public void testArrayListIteration() {
        List<Employee> empList = new CopyOnWriteArrayList<>();
        empList.add(e1);
        empList.add(e2);
        Iterator<Employee> itr = empList.iterator();

        empList.add(e3);

        // it will print only two elements because iterator was created before e3 addition
        while (itr.hasNext()) {
            Employee e = itr.next();
            System.out.println(e.getName());
        }

        // Prints 3
        System.out.println(empList.size());


    }

}
