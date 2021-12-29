package theory.person.withLambda;

import theory.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("aju", 31));
        personList.add(new Person("pavan", 31));
        personList.add(new Person("akshatha", 31));
        personList.add(new Person("kaveri", 26));
        personList.add(new Person("babu", 31));

        Consumer<Person> printName = (p) -> System.out.println(p.getName());
        Consumer<Person> printPerson = (p) -> System.out.println(p.toString());

        //Sort by name
        System.out.println("Sorting based on name");
        Collections.sort(personList, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        //prints all elements
        printConditional(personList, (p) -> true,printPerson);

        //print people who have name with a
        printConditional(personList, (p) -> p.getName().startsWith("a"),printName);
    }


    private static void printConditional(List<Person> personList, Predicate<Person> predicate, Consumer<Person> consumer) {
        System.out.println("Printing based on Condition");
        for (Person person : personList) {
            if (predicate.test(person)) {
                consumer.accept(person);
            }
        }
    }

}

