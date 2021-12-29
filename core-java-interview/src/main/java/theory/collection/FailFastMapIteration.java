package theory.collection;

import org.junit.Test;
import theory.stream.Employee;

import java.util.*;

public class FailFastMapIteration {

    Employee e1 = new Employee("aju", "123");
    Employee e2 = new Employee("kaveri", "123");
    Employee e3 = new Employee("akshatha", "123");


    @Test(expected = ConcurrentModificationException.class)
    public void testHashMapForEach() {
        Map<String, Employee> emap = new HashMap<>();
        emap.put("aju", e1);
        emap.put("kaveri", e2);
        emap.put("akshatha", e3);



        // Throws ConcurrentModification Exception
        emap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
            emap.remove(k);
        });

    }

    @Test(expected = ConcurrentModificationException.class)
    public void testHashMapForEachKeySet() {
        Map<String, Employee> emap = new HashMap<>();
        emap.put("aju", e1);
        emap.put("kaveri", e2);
        emap.put("akshatha", e3);

        // Throws concurrent modification Exception
        for(String key : emap.keySet()){
            emap.remove(key);
        }
    }


    @Test
    public void testHashMapIteration() {
        Map<String, Employee> emap = new HashMap<>();
        emap.put("aju", e1);
        emap.put("kaveri", e2);
        emap.put("akshatha", e3);

        // It wont throw concurrent modification because we are using iteratior method
        Iterator<Map.Entry<String, Employee>> entryIterator = emap.entrySet().iterator();
        while(entryIterator.hasNext()){
            Map.Entry<String, Employee> entry =  entryIterator.next();
            System.out.println(entry.getKey());
            entryIterator.remove();
        }

        System.out.println(emap.size());

    }



}
