package string;

/*
String is created in String pool in heap which is reused.
Here if a is having the reference of "hello"
b is also having same value, then it will also point  to the same reference


This optimisation is done only for String literal. Not for calcualed String or new String().
Thats why second comparison leads to false.

intern(). It checks if there is any matching string in the pool.
*/
public class Main {

    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";

        if (a == b) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }


        String c = "76";
        String d = new Integer("76").toString();
        if (c == d) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }


        String e = "86";
        String f = new Integer("86").toString().intern();
        if (e == f) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }

        String g = new String("hello");
        String h = new String("hello");
        if (g == h) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }

        String i = new String("hello").intern();
        String j = new String("hello").intern();
        if (i == j) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }
    }

}
