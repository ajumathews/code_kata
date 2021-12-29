package theory.datarace;
/*
Here garlicCount is shared between two threads .

The final output is unpredictable because both are accessing the same memory location.
Even though its an incremental operation- in the back ground its doing read, increment and modify.
So when multiple threads are accessing it , the values written back and read will cause race condition.


*/
public class Shopper implements Runnable {

    private int garlicCount;

    @Override
    public void run() {
        for(int i=0;i<1000000;i++){
            garlicCount++;
        }
    }

    public int getGarlicCount() {
        return garlicCount;
    }

    public static void main(String[] args) throws InterruptedException {
        Shopper shopper = new Shopper();
        Thread aju = new Thread(shopper);
        Thread ammu= new Thread(shopper);
        aju.start();
        ammu.start();
        aju.join();
        ammu.join();
        System.out.println(shopper.getGarlicCount());
    }
}
