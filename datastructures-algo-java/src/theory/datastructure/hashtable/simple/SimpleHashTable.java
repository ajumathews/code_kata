package theory.datastructure.hashtable.simple;

import theory.datastructure.model.Employee;

public class SimpleHashTable {

    private Employee[] hashTable;

    public SimpleHashTable() {
        hashTable = new Employee[10];
    }

    private int hashCode(String key) {
        return key.length() % hashTable.length;
    }

    public void put(String key, Employee e) {
        int index = hashCode(key);
        hashTable[index] = e;
    }

    public Employee get(String key){
        int index=hashCode(key);
        return hashTable[index];
    }

    public void printHashTable() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println(hashTable[i]);
        }
    }


}
