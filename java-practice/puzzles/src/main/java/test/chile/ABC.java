package test.chile;

public class ABC {

    public static void main(String[] args) {
        String a = "abc";
        String b = new String(a);
        System.out.println(a==b);

        String c = "xyz";
        String d = new String(c).intern();
        System.out.println(c == d);
    }
}
