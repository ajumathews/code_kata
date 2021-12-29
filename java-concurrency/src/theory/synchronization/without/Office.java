package theory.synchronization.without;

public class Office implements Runnable {
    private boolean endOfDay;

    @Override
    public void run() {
        System.out.println("Start of the day");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
        }
        endOfDay = true;
        System.out.println("End of the day");
    }

    public boolean isEndOfDay() {
        return endOfDay;
    }
}
