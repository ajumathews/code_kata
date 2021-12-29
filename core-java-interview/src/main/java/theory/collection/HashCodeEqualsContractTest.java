package theory.collection;

import org.junit.Test;

public class HashCodeEqualsContractTest {



    @Test
    public void test1(){
        Employee e1 = new Employee("aju","123");
        Employee e2 = new Employee("aju","123");

        // if two objects are equal by equal method then their hashcode will be same.
        // equal objects must have equal hashcode

        // If two objects are unequal they may or may not have same hashcode
        System.out.println(e1.equals(e2));
        System.out.println(e1.hashCode() == e2.hashCode());
    }
}
