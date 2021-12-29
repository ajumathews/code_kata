package theory.recursion;

public class Recursion {

    public void printNumberTillN(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        printNumberTillN(n - 1);
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        recursion.printNumberTillN(10);
    }
}
