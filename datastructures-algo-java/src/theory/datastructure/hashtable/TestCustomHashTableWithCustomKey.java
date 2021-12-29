package theory.datastructure.hashtable;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Objects;

class CustomHashTableWithCustomKey {

    private LinkedList<CustomElement>[] buckets;

    public CustomHashTableWithCustomKey() {
        buckets = new LinkedList[10];
    }

    public void put(Employee e, String dept) {
        int index = hashcode(e);
        LinkedList<CustomElement> bucket = buckets[index];
        if (bucket == null) {
            bucket = new LinkedList<>();
            buckets[index] = bucket;
        }
        bucket.addLast(new CustomElement(e, dept));
    }

    public Object get(Employee e) {
        int index = hashcode(e);
        LinkedList<CustomElement> bucket = buckets[index];
        if (bucket == null) {
            return null;
        }
        for (CustomElement c : bucket) {
            if (c.getEmployee().equals(e)) {
                return c.getDept();
            }
        }

        return null;
    }

    private int hashcode(Employee e) {
        System.out.println(e.hashCode());
        return e.hashCode() % buckets.length;
    }

}


class CustomElement {

    private Employee employee;
    private String dept;

    public CustomElement(Employee employee, String dept) {
        this.employee = employee;
        this.dept = dept;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}

class Employee {

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}


public class TestCustomHashTableWithCustomKey {

    @Test
    public void test1() {
        CustomHashTableWithCustomKey hashtable = new CustomHashTableWithCustomKey();
        Employee e1 = new Employee("aju", 32);
        Employee e2 = new Employee("anju", 29);
        hashtable.put(e1, "Java");
        hashtable.put(e2, "Db");

        Assert.assertEquals("Java", hashtable.get(e1));
        Assert.assertEquals("Db", hashtable.get(e2));

        // below test will fail if we dont override equals and hashcode
        Assert.assertEquals("Java", hashtable.get(new Employee("aju", 32)));
        Assert.assertNull(hashtable.get(new Employee("test", 32)));

    }

}
