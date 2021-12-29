package test.chile;

import java.util.TreeSet;

public class Treeset {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet();
        treeSet.add("Java");
        treeSet.add("Enterprise");
        treeSet.add("JavaEnterprise");
        treeSet.add("Java");

        for(String s: treeSet){
            System.out.println(s);
        }
    }
}
