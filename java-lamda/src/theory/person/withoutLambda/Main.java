package theory.person.withoutLambda;

import theory.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("aju", 31));
        personList.add(new Person("pavan", 31));
        personList.add(new Person("akshatha", 31));
        personList.add(new Person("kaveri", 26));
        personList.add(new Person("babu", 31));

        //Sort by name
        System.out.println("Sorting based on name");
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        //prints all elements
        printElements(personList);

        //print people who have name with a
        printConditional(personList, new Condition() {
            @Override
            public boolean test(Person p) {
               return (p.getName().startsWith("a"));
            }
        });

    }


    private static void printConditional(List<Person> personList, Condition condition) {
        System.out.println("Sorting based on Condition");
        for (Person person : personList) {
            if (condition.test(person)) {
                System.out.println(person.toString());
            }
        }
    }


    private static void printElements(List<Person> personList) {
        System.out.println("Printing All elements");
        for (Person person : personList) {
            System.out.println(person.toString());
        }

    }
}

interface Condition{
    boolean test(Person p);
}
