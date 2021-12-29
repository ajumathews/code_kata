package theory.basics;

public class CPUWaster extends Thread {
    @Override
    public void run() {
        while (true) {

        }
    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long usedMemory = (runtime.totalMemory() - runtime.freeMemory())/1024;
        System.out.println("Used Memory : "+usedMemory);
        System.out.println("Thread Count: "+Thread.activeCount());

        for(int i=0;i<8;i++){
            new CPUWaster().start();
        }

        usedMemory = (runtime.totalMemory() - runtime.freeMemory())/1024;
        System.out.println("Used Memory : "+usedMemory);
        System.out.println("Thread Count: "+Thread.activeCount());



    }
}
