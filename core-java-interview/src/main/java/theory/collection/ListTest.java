package theory.collection;

import org.junit.Test;
import theory.stream.Employee;

import java.util.*;

public class ListTest {

    Employee e1 = new Employee("aju", "123");
    Employee e2 = new Employee("kaveri", "123");
    Employee e3 = new Employee("akshatha", "123");

    @Test
    public void testArrayList() {
        List<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);

        // Insertion order is preserved
       empList.forEach((e) -> System.out.println(e.getName()));
    }






}
