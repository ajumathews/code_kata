package theory.challenges.arrays;


import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {


    private static boolean sameNaive(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] * arr1[i] == arr2[j]) {
                    arr2[j] = -1;
                    break;
                } else if (j == arr2.length - 1) {
                    return false;
                }
            }

        }

        return true;
    }

    private static boolean same(int[] arr1, int[] arr2) {

        Map<Integer, Integer> frequencyCounter1 = new HashMap<>();
        Map<Integer, Integer> frequencyCounter2 = new HashMap<>();

        for (int i : arr1) {
            frequencyCounter1.get(i);
            Integer frequency = frequencyCounter1.get(i);
            if (frequency == null) {
                frequencyCounter1.put(i, 1);
            } else {
                frequencyCounter1.put(i, frequency + 1);
            }
        }

        for (int i : arr2) {
            Integer frequency = frequencyCounter2.get(i);
            if (frequency == null) {
                frequencyCounter2.put(i, 1);
            } else {
                frequencyCounter2.put(i, frequency + 1);
            }
        }

        for (Integer key : frequencyCounter1.keySet()) {
            if (frequencyCounter2.get(key * key) == null) {
                return false;
            }
            if (frequencyCounter1.get(key) != frequencyCounter2.get(key * key)) {
                return false;
            }
        }

        return true;
    }



    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 3, 0};
        int[] arr2 = {1, 4, 9, 0};

        System.out.println(FrequencyCounter.same(arr1, arr2));
    }
}
