package theory.datastructure.hashtable;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

class CustomHashTable {

    private LinkedList<Element>[] buckets;


    public CustomHashTable() {
        this.buckets = new LinkedList[10];
    }

    public void put(String key, int value) {
        int index = hashcode(key);
        LinkedList<Element> bucket = buckets[index];
        if (bucket == null) {
            bucket = new LinkedList<>();
            buckets[index] = bucket;
        }
        bucket.addLast(new Element(key, value));
    }


    public Object get(String key) {
        int index = hashcode(key);
        LinkedList<Element> bucket = buckets[index];
        if (bucket == null) {
            return null;
        }
        for (Element e : bucket) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return null;
    }

    private int hashcode(String key) {
        System.out.println(key.hashCode() % buckets.length);
        return key.hashCode() % buckets.length;
    }

}

class Element {
    String key;
    Integer value;

    public Element(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

public class TestCustomHashTable {

    @Test
    public void testCase1() {
        CustomHashTable customHashTable = new CustomHashTable();
        customHashTable.put("one", 1);
        customHashTable.put("two", 2);

        Assert.assertEquals(1, customHashTable.get("one"));
        Assert.assertEquals(2, customHashTable.get("two"));
        Assert.assertNull(customHashTable.get("three"));
    }

    @Test
    public void testCase2Collision() {
        CustomHashTable customHashTable = new CustomHashTable();
        customHashTable.put("one", 1);
        customHashTable.put("eno", 2);

        Assert.assertEquals(1, customHashTable.get("one"));
        Assert.assertEquals(2, customHashTable.get("eno"));
    }


}
