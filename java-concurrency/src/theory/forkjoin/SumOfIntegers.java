package theory.forkjoin;

public class SumOfIntegers {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long total = 0;
        for (long i = 0; i < 999999999; i++) {
            total += i;
        }
        System.out.println(total);
        long end=System.currentTimeMillis();
        System.out.println("Time taken :"+(end-start));
    }
}
