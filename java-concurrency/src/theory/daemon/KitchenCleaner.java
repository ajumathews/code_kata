package theory.daemon;

/*
If the Cleaner thread is a normal user thread, it keeps executing even though the main thread is finished. It prrevents the JVM from
exiting the program.


If the cleaner thread is marked as Daemon, it exits as soon as the main thread completes.
You can see the finally method of cleaner thread is not called

*/
public class KitchenCleaner implements Runnable {
    @Override
    public void run() {
        System.out.println("Kitchen cleaner Started");
        while (true) {
            System.out.println("Cleaning the kitchen");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            } finally {
                System.out.println("Cleaning completed");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread cleaner = new Thread(new KitchenCleaner());
        cleaner.setDaemon(true);
        cleaner.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Chef cooking");
            Thread.sleep(1000);
        }


        System.out.println("Main Chef is done");

    }
}
