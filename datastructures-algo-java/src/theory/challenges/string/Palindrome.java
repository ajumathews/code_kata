package theory.challenges.string;


/*

Check Palindrome -
    malayalam
    abcdcba

* */
public class Palindrome {


    /*
     Time Complexity - O(n ^2) - Because when we append a char, we are creating a new String - it has to iterate n times
     Space Complexity - O(n)
    * */
    private static boolean checkPalindromeNaive(String input) {
        String reverse = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reverse += input.charAt(i);

        }
        if (input.equals(reverse)) {
            return true;
        }
        return false;
    }


    /*
    Time Complexity - O(n) - Because we use StringBuilder and appending is O(n)
     Space Complexity - O(n)
    * */
    private static boolean checkPalindromeNaiveStringBuilder(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            stringBuilder.append(input.charAt(i));

        }
        if (input.equals(stringBuilder.toString())) {
            return true;
        }
        return false;
    }

    /*
        M A L A Y A L A M

    leftPointer = 0
    rightPointer = 7
        if both are equal check the inner String to be a palindrome

    A L A Y A L A
    leftPointer = 1
    rightPointer = 6
        if both are equal check the inner String to be a palindrome

    L A Y A L
    leftPointer = 2
    rightPointer = 5
        if both are equal check the inner String to be a palindrome

    Time Complexity - O(n) -
     Space Complexity - O(n) - Because of callStack
    * */
    private static boolean checkPalindromeRecursive(String input) {
        return palindromeRecursiveHelper(input, 0, input.length() - 1);
    }


    private static boolean palindromeRecursiveHelper(String input, int i, int j) {
        if (i >= j) {
            return true;
        }

        return (input.charAt(i) == input.charAt(j) && palindromeRecursiveHelper(input, i+1, j-1));
    }


    /*
      M A L A Y A L AM

    leftPointer = 0
    rightPointer = 7

     check leftPointer value and rightPointer value
        -- return false if not equal
        -- increment left and decrement right if equals

      Repeat till leftPointer less than rightPointer.

    TimeComplexity - O(n)
    SpaceComplexity - O(1)

    * */
    private static boolean checkPalindromeBest(String input) {
        int leftPointer = 0;
        int rightPointer = input.length() - 1;

        while (leftPointer <= rightPointer) {
            if (input.charAt(leftPointer) == input.charAt(rightPointer)) {
                leftPointer++;
                rightPointer--;
            } else {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(checkPalindromeRecursive("aju"));
        System.out.println(checkPalindromeRecursive("malayalam"));

    }
}
