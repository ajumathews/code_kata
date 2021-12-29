package theory.basics;

public class VegetableChopper extends Thread {

    private int vegCount;
    private static boolean chopping;

    public VegetableChopper(String name){
        this.setName(name);
    }

    @Override
    public void run() {
        while (chopping) {
            vegCount++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VegetableChopper aju = new VegetableChopper("aju");
        VegetableChopper ammu = new VegetableChopper("ammu");
        VegetableChopper.chopping=true;
        aju.start();
        ammu.start();
        Thread.sleep(1000);
        System.out.println("Chopped By Aju:"+aju.getVegCount());
        System.out.println("Chopped By Ammu:"+ammu.getVegCount());
    }

    public int getVegCount() {
        return vegCount;
    }


}
