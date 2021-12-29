package theory.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

public class TerminalOperations {

    Employee e1 = new Employee("aju", "123");
    Employee e2 = new Employee("kaveri", "345");
    Employee e3 = new Employee("akshatha", "678");
    List<Employee> employeeList =  Arrays.asList(e1,e2,e3);



    @Test
    public void testAnyMatch() {
        // anyMatch returns boolean
        Predicate<Employee> nameMatcherA = (e) -> e.getName().startsWith("a");
        System.out.println(employeeList.stream().anyMatch(nameMatcherA));
    }

    @Test
    public void testAllMatch() {

        // allMatch returns boolean
        Predicate<Employee> nameMatcherA = (e) -> e.getName().startsWith("a");
        System.out.println(employeeList.stream().allMatch(nameMatcherA));
    }

    @Test
    public void testFindFirst() {

        // FindAny // FindFirst
        Predicate<Employee> nameMatcherA = (e) -> e.getName().startsWith("a");
        System.out.println(employeeList.stream().findAny().orElse(null));
    }

    @Test
    public void testMax() {
        // Min/ Max

        Comparator<Employee> idComparator = Comparator.comparing(Employee::getId);
        System.out.println(employeeList.stream().max(idComparator).orElse(null));
    }

}
