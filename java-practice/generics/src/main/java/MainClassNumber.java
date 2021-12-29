public class MainClassNumber {

    public static void main(String[] args) {
       MyListNumber<Integer> l1 = new MyListNumber<>();
       l1.add(1);
       l1.add(2);
       System.out.println(l1.sumOfElements());

        MyListNumber<Double> l2 = new MyListNumber<>();
        l2.add(1.2);
        l2.add(2.2);
        System.out.println(l2.sumOfElements());

    }

}
