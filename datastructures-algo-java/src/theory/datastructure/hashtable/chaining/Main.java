package theory.datastructure.hashtable.chaining;

import theory.datastructure.model.Employee;

public class Main {

    public static void main(String[] args) {
        Employee aju = new Employee("Aju", 31);
        Employee anju = new Employee("Anju", 28);
        Employee babu = new Employee("Babu", 31);


        ChainingHashTable hashTable = new ChainingHashTable();

        /*Put Operation*/
        hashTable.put("aju",aju);
        hashTable.put("anju",anju);

        /*Collition happened. the last value is overwritten with this implementation*/
        hashTable.put("babu",babu);


        hashTable.printHashTable();

        /*Get Operation*/
        System.out.println(hashTable.get("aju"));


        /*Remove Operation*/
        hashTable.remove("aju");

        hashTable.printHashTable();
    }
}
