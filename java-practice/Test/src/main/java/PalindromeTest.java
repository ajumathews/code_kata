import java.util.HashMap;
import java.util.Locale;

public class PalindromeTest {


    static boolean checkPalindromeBasic(String input) {

        // Remove all special chars and space
        StringBuilder cleanedInput = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int asci = input.charAt(i);
            if (asci >= 'A' && asci <= 'z') {
                cleanedInput.append(input.charAt(i));
            }
        }

        // Reverse the string
        StringBuilder reverseString = new StringBuilder();
        for (int i = cleanedInput.length() - 1; i >= 0; i--) {
            reverseString.append(cleanedInput.charAt(i));
        }

        // Check if its equal
        return cleanedInput.toString().equalsIgnoreCase(reverseString.toString());
    }


    static boolean checkPalindromeOptimized(String input) {
        // Flee to me, remote elf!";
        // Remove all special chars and space
        StringBuilder cleanedInput = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int asci = input.charAt(i);
            if (asci >= 'A' && asci <= 'z') {
                cleanedInput.append(Character.toLowerCase(input.charAt(i)));
            }
        }

        for (int i = 0; i < cleanedInput.length(); i++) {
            if(cleanedInput.charAt(i) != cleanedInput.charAt(cleanedInput.length()-i-1)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        String input = "Flee to me, remote elf!";

        //String input = "emote elf!";

        System.out.println(checkPalindromeBasic(input));
        System.out.println(checkPalindromeOptimized(input));

    }

}
