package gc;

/*
By Calling the GC method we cant ensure JVM calls it.
By implementing something in the finalize method also we cant make sure JVM calls that.
It should be used only for logging at the max.

*/
public class Main {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();

        System.out.println("Before creation:"+runtime.freeMemory()/1024);
        for (int i = 0; i < 100; i++) {
            Book b = new Book("hello", "hello");
        }
        System.out.println("After creation :"+runtime.freeMemory()/1024);
        System.gc();
        System.out.println("After GC :"+runtime.freeMemory()/1024);


    }
}
