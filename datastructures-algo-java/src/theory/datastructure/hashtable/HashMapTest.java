package theory.datastructure.hashtable;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapTest {


    @Test
    public void test1() {
        Map<Student, String> map = new HashMap<>();
        Student s1 = new Student("aju", 32);
        Student s2 = new Student("aju", 32);

        /*This will fail if equals is not overridden because by default equals method compare object reference*/
        Assert.assertEquals(s1, s2);
    }

    @Test
    public void test2() {
        Map<Student, String> map = new HashMap<>();
        Student s1 = new Student("aju", 32);
        map.put(s1, "Java");

        /*This will fail if hashcode is not overridden because the keys will generate different hashcoode*/
        Assert.assertEquals("Java", map.get(new Student("aju", 32)));

    }


}

class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
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
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

