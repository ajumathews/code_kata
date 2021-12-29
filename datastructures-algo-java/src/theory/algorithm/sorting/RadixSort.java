package theory.algorithm.sorting;

import java.util.Arrays;



/*

This sort also can be applied on integers.

Time complexity - O(nk) k - number of digits
Space complexity - O(n+k)

if all the numbers are different computer stores number then k become logn. so the BigO become O(n logn) which means
radix sort is comparatively to Comparison sort.

* */
public class RadixSort {


    static void radixSort(int[] arr) {

        /*Find max number*/
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        /*Find number of digits in max number*/
        int numberOfDigits = 1;
        for (int i = max / 10; i > 0; i /= 10) {
            numberOfDigits++;
        }

        /*Do the counting based on the unit, tens etc*/
        int placeValue = 1;
        while (numberOfDigits > 0) {
            countingSort(arr, placeValue);
            placeValue *= 10;
            numberOfDigits--;
        }

    }

    static void countingSort(int[] arr, int placeValue) {
        int range = 10;
        /*initialise and populate the countArray of digits*/
        int[] countArr = new int[range + 1];
        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] / placeValue % range;
            countArr[digit]++;
        }

        /*Add consecutive values*/
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] = countArr[i] + countArr[i - 1];
        }

        /*Iterate the input array and create a new sorted array and place elements based on the index in the count array in the reverse order*/

        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int currentElement = arr[i];
            int digit = currentElement / placeValue % range;
            result[countArr[digit] - 1] = currentElement;
            countArr[digit]--;
        }

        /*copy the result back to the input arr*/
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }

    }


    public static void main(String[] args) {
        int[] arr = {387, 468, 134, 123, 68, 221, 769, 37, 7};
        radixSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
