package theory.datastructure.hashtable.chaining;

import theory.datastructure.model.Employee;

import java.util.*;

public class ChainingHashTable {

    private LinkedList[] hashTable;

    public ChainingHashTable() {
        hashTable = new LinkedList[10];
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList();
        }
    }

    private int hashCode(String key) {
        return key.length() % hashTable.length;
    }

    public void put(String key, Employee e) {
        int index = hashCode(key);
        hashTable[index].add(new StoredEmployee(key, e));
    }

    public Employee get(String key) {
        int index = hashCode(key);
        Iterator<StoredEmployee> itr = hashTable[index].iterator();
        while (itr.hasNext()) {
            StoredEmployee storedEmployee = itr.next();
            if (storedEmployee.getKey().equals(key)) {
                return storedEmployee.getEmployee();
            }
        }
        return null;
    }

    public Employee remove(String key) {
        int index = hashCode(key);
        if (hashTable[index].isEmpty()) {
            return null;
        } else {
            Iterator<StoredEmployee> iterator = hashTable[index].iterator();
            while (iterator.hasNext()) {
                StoredEmployee storedEmployee = iterator.next();
                if (storedEmployee.getKey().equals(key)) {
                    iterator.remove();
                    return storedEmployee.getEmployee();
                }
            }
        }
        return null;
    }


    public void printHashTable() {


        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i].isEmpty()) {
                System.out.println(i + ":Empty Index");
            } else {
                System.out.print(i + ":");
                Iterator<StoredEmployee> itr = hashTable[i].iterator();
                while (itr.hasNext()) {
                    StoredEmployee storedEmployee = itr.next();
                    System.out.print(storedEmployee.getEmployee());
                    System.out.print("->");
                }
                System.out.println("null");
            }
        }
    }


}
