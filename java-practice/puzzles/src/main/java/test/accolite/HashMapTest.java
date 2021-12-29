package test.accolite;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("aju","java");
        map.put(new String("aju"),"rest");

        System.out.println("aju".hashCode());
        System.out.println(new String("aju").hashCode());


        System.out.println(map.get("aju"));
    }

}
