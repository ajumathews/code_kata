package theory.streams;

import theory.model.Person;

import java.util.ArrayList;
import java.util.List;

/*
its like an pipeline. where elements go in each functions.

A Stream has three parts.
First part is view of the source - personList
Second part is the operations on the Stream
Third part is the terminal Operation - in this case Foreach and count

parallelStream - leverage parallel processing

* */
public class StreamsExample {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("aju", 31));
        personList.add(new Person("pavan", 31));
        personList.add(new Person("akshatha", 31));
        personList.add(new Person("kaveri", 26));
        personList.add(new Person("babu", 31));


        personList.stream()
                .filter((p) -> p.getName().startsWith("a"))
                .forEach(System.out::println);

        long ageCount = personList.stream()
                .filter((p) -> p.getAge() == 31)
                .count();


        long nameCount = personList.parallelStream()
                .filter((p) -> p.getName().startsWith("b"))
                .count();

        System.out.println(ageCount);
        System.out.println(nameCount);

    }
}
