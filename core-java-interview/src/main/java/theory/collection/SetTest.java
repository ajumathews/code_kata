package theory.collection;

import org.junit.Test;
import theory.stream.Employee;

import java.util.*;

public class SetTest {


    Employee e1 = new Employee("aju", "123");
    Employee e2 = new Employee("kaveri", "123");
    Employee e3 = new Employee("akshatha", "123");
    Employee e4 = new Employee("aju", "123");

    @Test
    public void testHashSet() {
        Set<Employee> empSet = new HashSet<>();
        empSet.add(e1);
        empSet.add(e2);
        empSet.add(e3);

        // It wont be added due to hashCode and Equals contract , But no order
        empSet.add(e4);

        empSet.forEach((e) -> System.out.println(e.getName()));
    }


    @Test
    public void testLinkedHashSet() {
        Set<Employee> empSet = new LinkedHashSet<>();
        empSet.add(e1);
        empSet.add(e2);
        empSet.add(e3);

        // Insertion Order will be preserved

        empSet.forEach((e) -> System.out.println(e.getName()));
    }



    @Test
    public void testTreeSet() {
        Comparator<Employee> nameComparator = Comparator.comparing(Employee::getName);
        Set<Employee> empSet = new TreeSet<>(nameComparator);


        empSet.add(e1);
        empSet.add(e2);
        empSet.add(e3);

        // Order will be based on the natural ordering or by Compartor

        empSet.forEach((e) -> System.out.println(e.getName()));
    }

}

