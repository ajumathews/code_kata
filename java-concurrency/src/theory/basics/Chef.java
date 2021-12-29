package theory.basics;

public class Chef extends Thread {

    public Chef(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        System.out.println("Chef " + this.getName() + this.getId() + " started cooking");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        System.out.println("Chef " + this.getName() + " finished cooking");
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main Chef started cooking");

        Chef ammu = new Chef("ammu");
        ammu.start();

        Thread.sleep(2000);
        System.out.println("Main Chef finished cooking");

        System.out.println("Main Chef Waiting for " + ammu.getName() + " to finish");

        ammu.join();
        System.out.println("Completed Cooking");

    }
}
