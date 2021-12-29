package theory.challenges.arrays;

import java.util.HashMap;
import java.util.Map;


public class Anagram {

    private static boolean isAnagramUsingMap(String s1, String s2) {
        s1 = s1.toLowerCase().replaceAll(" ", "");
        s2 = s2.toLowerCase().replaceAll(" ", "");


        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (Character c : s1.toCharArray()) {
            Integer frequency = m1.get(c);
            if (frequency == null) {
                m1.put(c, 1);
            } else {
                m1.put(c, frequency + 1);
            }
        }


        for (Character c : s2.toCharArray()) {
            Integer frequency = m2.get(c);
            if (frequency == null) {
                m2.put(c, 1);
            } else {
                m2.put(c, frequency + 1);
            }

        }

        for (Character c : m1.keySet()) {
            if (m2.get(c) == null) {
                return false;
            }
            if (m1.get(c) != m2.get(c)) {
                return false;
            }
        }
        return true;
    }


    private static boolean isAnagramBasic(String s1, String s2) {
        s1 = s1.toLowerCase().replaceAll(" ", "");
        s2 = s2.toLowerCase().replaceAll(" ", "");

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();


        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                if (c1[i] == c2[j]) {
                    c2[j] = '.';
                    break;
                } else {
                    if (j == s2.length() - 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    private static boolean isAnagram(String s1, String s2) {

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();


        int countS1[] = new int[256];
        int countS2[] = new int[256];


        for (int i = 0; i < s1.length(); i++) {
            countS1[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            countS2[s2.charAt(i)]++;
        }

        for (int i = 0; i < countS1.length; i++) {
            if (countS1[i] != countS2[i]) {
                return false;
            }
        }

        return true;
    }


    private static boolean isAnagramAdvanced(String s1, String s2) {

        s1 = s1.toLowerCase().replaceAll(" ","");
        s2 = s2.toLowerCase().replaceAll(" ","");

        int count[] = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (count[s2.charAt(i)] > 0) {
                count[s2.charAt(i)]--;
            }
        }


        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(Anagram.isAnagramAdvanced("", ""));
        System.out.println(Anagram.isAnagramAdvanced("car", "act"));
        System.out.println(Anagram.isAnagramAdvanced("car", "arc"));
        System.out.println(Anagram.isAnagramAdvanced("Mother In Law", "Hitler Woman"));

        //Good test

        System.out.println(Anagram.isAnagram("bbcc", "dabc"));
    }
}
