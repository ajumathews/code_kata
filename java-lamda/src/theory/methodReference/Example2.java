package theory.methodReference;


import theory.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/*
Here in the lambda we are calling a method with the same parameter passed as argument
so this can be replace by the method reference
* */
public class Example2 {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("aju", 31));
        personList.add(new Person("pavan", 31));
        personList.add(new Person("akshatha", 31));
        personList.add(new Person("kaveri", 26));
        personList.add(new Person("babu", 31));

        Consumer<Person> printName = (p) -> System.out.println(p);
        Consumer<Person> printNameWithMethodReference = System.out::println;

        for(Person p:personList){
            printNameWithMethodReference.accept(p);
        }
    }





}
