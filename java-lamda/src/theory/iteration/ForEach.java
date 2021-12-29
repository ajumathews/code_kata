package theory.iteration;

import theory.model.Person;

import java.util.ArrayList;
import java.util.List;

public class ForEach {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("aju", 31));
        personList.add(new Person("pavan", 31));
        personList.add(new Person("akshatha", 31));
        personList.add(new Person("kaveri", 26));
        personList.add(new Person("babu", 31));

        //External Iteration - We are controlling the theory.iteration.
        for(Person p:personList){
            System.out.println(p);
        }

        //Internal Iteration - The Runtime iterates. it may use multithreaded code to do
        personList.forEach(p-> System.out.println(p.getName()));

        personList.forEach(System.out::println);

    }
}
