package theory.threadpool.with;

/*
Here it will create 100 threads 
*/
public class Main {

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(new VegetableChopper()).start();
        }
    }
}
