package theory.collection;

import org.junit.Test;
import theory.stream.Employee;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeMapIteration {

    Employee e1 = new Employee("aju", "123");
    Employee e2 = new Employee("kaveri", "123");
    Employee e3 = new Employee("akshatha", "123");


    @Test
    public void testHashMapForEach() {
        Map<String, Employee> emap = new ConcurrentHashMap<>();
        emap.put("aju", e1);
        emap.put("kaveri", e2);
        emap.put("akshatha", e3);



        //It doesnt throws concurrent Modification Exception
        emap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
            emap.remove(k);
        });

        System.out.println(emap.size());

    }



    @Test
    public void testHashMapIteration() {
        Map<String, Employee> emap = new ConcurrentHashMap<>();
        emap.put("aju", e1);
        emap.put("kaveri", e2);
        emap.put("akshatha", e3);

        // It won't throw concurrent modification because we are using iterator method
        Iterator<Map.Entry<String, Employee>> entryIterator = emap.entrySet().iterator();
        while(entryIterator.hasNext()){
            Map.Entry<String, Employee> entry =  entryIterator.next();
            System.out.println(entry.getKey());
            entryIterator.remove();
        }

        System.out.println(emap.size());

    }




}
