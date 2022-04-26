package theory.collection;

import org.junit.Test;
import theory.stream.Employee;

import java.util.*;

public class MapTest {

    Employee e4 = new Employee("aju", "123");

    Employee e1 = new Employee("aju", "123");
    Employee e2 = new Employee("kaveri", "123");
    Employee e3 = new Employee("akshatha", "123");

    @Test
    public void testHashMap() {
        Map<String, Employee> emap = new HashMap<>();
        emap.put("aju", e1);
        emap.put("kaveri", e2);
        emap.put("akshatha", e3);
        emap.put("babu", e1);

        // HashMap maintains No Insertion Order;
        // Not ThreadSafe

        emap.forEach((k, v) -> System.out.println(k + ":" + v));


    }

    @Test
    public void testLinkedHashMap() {
        Map<String, Employee> emap = new LinkedHashMap<>();
        emap.put("aju", e1);
        emap.put("kaveri", e2);
        emap.put("akshatha", e3);
        emap.put("babu", e1);

        // LinkedHashMap maintains Insertion Order;
        // Not ThreadSafe
        emap.forEach((k, v) -> System.out.println(k + ":" + v));


    }

    @Test
    public void testTreeMap() {
        Map<String, Employee> emap = new TreeMap<>();
        emap.put("aju", e1);
        emap.put("kaveri", e2);
        emap.put("akshatha", e3);
        emap.put("babu", e1);

        // TreeMap sort the entries based on the keys. In this case it does a natural sorting for String;

        // Not ThreadSafe

        emap.forEach((k, v) -> System.out.println(k + ":" + v));

    }

    @Test
    public void testHashTable() {
        Map<String, Employee> emap = new Hashtable<>();
        emap.put("aju", e1);
        emap.put("kaveri", e2);
        emap.put("akshatha", e3);
        emap.put("babu", e1);
        //emap.put(null, e1);

        // emap.put("test", null);

        // HashTable maintains no order. It doesn't allow null key / value
        // HashTable have synchronised method
        emap.forEach((k, v) -> System.out.println(k + ":" + v));

    }


}

