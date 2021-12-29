public class MainClass {

    public static void main(String[] args) {
        MyList<String> l1 = new MyList<>();
        l1.addElement("hello");
        l1.addElement("world");
        System.out.println(l1.toString());
        System.out.println(l1.get(0));

        MyList<Integer> l2 = new MyList<>();
        l2.addElement(10);
        l2.addElement(20);
        System.out.println(l2.toString());
        System.out.println(l2.get(0));


    }

}
