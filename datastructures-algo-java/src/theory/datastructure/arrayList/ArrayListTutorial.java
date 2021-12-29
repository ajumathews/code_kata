package theory.datastructure.arrayList;

import theory.datastructure.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTutorial {

    public static void main(String[] args) {

        Employee e1 = new Employee("Aju", 31);
        Employee e2 = new Employee("Anju", 28);

        List<Employee> employeeList = new ArrayList<>();

        /*
        Adding element
        O(1) - because the element is added to the last index, the only thing is if the
         size of the array is full, it will create a new array and copy items to it
         */
        employeeList.add(e1);
        employeeList.add(e2);

        /*I can add the same object*/
        Employee e3 = new Employee("Aju", 31);
        employeeList.add(e3);

        /*
        Retrieving
        O(1)- since array retrieval based on index is constant time
        */
        employeeList.get(1);

        /*
        Updating
        O(1) - since array updating based on index is constant time operation
        */
        Employee e4 = new Employee("Ammu", 28);
        employeeList.set(1, e4);

        /*
        Add an element to an specific index
        O(n) - since array has to be shifted to accommodate the new item
        */
        Employee e5 = new Employee("Dodo", 18);
        employeeList.add(2, e5);

        /*
        Removal with index
        O(n) - since array has to be shifted after removal of the item
        */
        employeeList.remove(2);

        /*
        Removal with object
        O(n) - since array has to be shifted after removal of the item
        Here also the object is not removed if we dont override equals method
        */
        employeeList.remove(new Employee("Aju", 31));

        /*
        Indexof/ Contains
        O(n) - we have to check each element
        Here element Found will be false if we dont override equals method to check the values
        So list is checking the Address of the object
        */
        boolean elementFound = employeeList.contains(new Employee("Ammu", 28));
        System.out.println(elementFound);
        int index = employeeList.indexOf(new Employee("Ammu", 28));
        System.out.println(index);


        employeeList.forEach(employee -> System.out.println(employee));

    }

}
