package theory.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecursiveSum extends RecursiveTask<Long> {

    private long low, high;

    public RecursiveSum(long low, long high) {
        this.low = low;
        this.high = high;
    }

    @Override
    protected Long compute() {
        /*Base case where we are summing up till a reasonable number */
        if (high - low < 10000) {
            long total = 0;
            for (long i = low; i <= high; i++) {
                total += i;
            }
            return total;
        } else {

            long mid = (high + low) / 2;
            RecursiveSum left = new RecursiveSum(low, mid);
            RecursiveSum right = new RecursiveSum(mid + 1, high);
            left.fork();
            return right.compute() + left.join();
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Long result= pool.invoke(new RecursiveSum(0,999999999));
        System.out.println(result);
        long end=System.currentTimeMillis();
        System.out.println("Time taken :"+(end-start));
    }
}
