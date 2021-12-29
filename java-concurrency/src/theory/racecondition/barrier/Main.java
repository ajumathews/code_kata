package theory.racecondition.barrier;

/*
Here we are using a barrier. it makes sure all ajus are executed first then ammus threads
Barrier will release when certain number of threads are waiting.
* */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Shopper[] shoppers = new Shopper[10];
        for (int i = 0; i < shoppers.length / 2; i++) {
            shoppers[2 * i] = new Shopper("aju");
            shoppers[2 * i + 1] = new Shopper("ammu");
        }

        for (Shopper shopper : shoppers) {
            shopper.start();
        }

        for (Shopper shopper : shoppers) {
            shopper.join();
        }

        System.out.println("Bag of chips :" + Shopper.chipsPacket);
    }
}
