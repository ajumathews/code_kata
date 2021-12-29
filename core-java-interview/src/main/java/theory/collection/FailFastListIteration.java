package theory.collection;

import org.junit.Test;
import theory.stream.Employee;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class FailFastListIteration {

    Employee e1 = new Employee("aju", "123");
    Employee e2 = new Employee("kaveri", "123");
    Employee e3 = new Employee("akshatha", "123");

    @Test(expected = ConcurrentModificationException.class)
    public void testArrayListConcurrentModification() {
        List<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);

        // it will throw concurrentModificationException since structure is modified while iterating
        empList.forEach((e) -> {
            System.out.println(e.getName());
            empList.remove(e);
        });

    }

    @Test
    public void testArrayListIteration() {
        List<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);

        // it will not throw concurrentModificationException since we are using iterators add / remove methods
        Iterator<Employee> itr = empList.iterator();
        while(itr.hasNext()){
            Employee e = itr.next();
            System.out.println(e.getName());
            itr.remove();
        }

        // All elements are removed
        System.out.println(empList.size());


    }

    @Test(expected = ConcurrentModificationException.class)
    public void testArrayListIterationFailFast() {
        List<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);

        // it will throw concurrentModificationException since we are modifiying the underlying collection
        Iterator<Employee> itr = empList.iterator();
        while(itr.hasNext()){
            Employee e = itr.next();
            System.out.println(e.getName());
            empList.remove(e);
        }

        // All elements are removed
        System.out.println(empList.size());

    }
}
