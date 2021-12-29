package theory.runnable;

/*
Since Compiler does the type inference we know the thread class take the Runnable Interface.
We can pass a lambda into that which no return type and no arguments.
*/
public class RunnableLambda {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Printed inside Run method of inner class");
            }
        });

        t1.start();

        Thread t2 = new Thread(()-> System.out.println("Printed inside Run method of lambda"));
        t2.start();
    }
}
