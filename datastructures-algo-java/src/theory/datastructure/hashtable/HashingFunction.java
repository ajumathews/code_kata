package theory.datastructure.hashtable;

public class HashingFunction {


    static int hash(String input, int arrayLength) {

        int total = 0;
        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i);
            total = (total + val) % arrayLength;
        }
        return total;
    }


    static int hashRobust(String input, int arrayLength) {

        int total = 0;
        int primeNumber = 31;
        for (int i = 0; i < input.length() && i < 100; i++) {
            int val = input.charAt(i);
            total = (total * primeNumber + val) % arrayLength;
        }
        return total % arrayLength;
    }


    public static void main(String[] args) {

        System.out.println(hash("hello", 10));
        System.out.println(hash("pink", 10));


        System.out.println(hashRobust("hello", 10));
        System.out.println(hashRobust("pink", 10));
    }
}
