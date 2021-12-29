package theory.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NonTerminalOperations {

    Employee e1 = new Employee("aju", "123");
    Employee e2 = new Employee("kaveri", "345");
    Employee e3 = new Employee("akshatha", "678");
    List<Employee> employeeList = Arrays.asList(e1, e2, e3);

    @Test
    public void testFilter() {
        // Filtering emp by name 'a'
        Predicate<Employee> empNameStartsWithA = (e) -> e.getName().startsWith("a");
        Consumer<Employee> namePrint = (e) -> System.out.println(e.getName());
        employeeList.stream().filter(empNameStartsWithA).forEach(namePrint);
    }


    @Test
    public void testMap() {
        // Uppercase name
        Consumer<Employee> namePrint = (e) -> System.out.println(e.getName());
        Function<Employee,Employee> upperCase = (e) -> {
            e.setName(e.getName().toUpperCase());
            return e;
        };

        employeeList.stream().map(upperCase).forEach(namePrint);
    }


    @Test
    public void testLimit() {
        // Uppercase name
        Consumer<Employee> namePrint = (e) -> System.out.println(e.getName());
        employeeList.stream().limit(2).forEach(namePrint);
    }

    @Test
    public void testSkip() {
        // Uppercase name
        Consumer<Employee> namePrint = (e) -> System.out.println(e.getName());
        employeeList.stream().skip(2).forEach(namePrint);
    }


}
