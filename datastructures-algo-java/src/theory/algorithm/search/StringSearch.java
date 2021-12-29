package theory.algorithm.search;

public class StringSearch {

    private static int findOccurrence(String inputString, String searchTerm) {
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            for (int j = 0; j < searchTerm.length(); j++) {
                if (inputString.charAt(i) != searchTerm.charAt(j)) {
                    break;
                } else {
                    i++;
                }
                if (j == searchTerm.length() - 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String inputString = "aju and anju";
        System.out.println(findOccurrence(inputString, "a"));

    }
}
