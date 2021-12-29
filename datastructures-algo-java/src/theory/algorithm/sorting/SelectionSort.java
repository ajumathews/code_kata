package theory.algorithm.sorting;

/*
 *
 * First Pass - 4 iteration
 * {1,4,5,2,3}
 * {1,4,5,2,3}
 * {1,4,5,2,3}
 * {1,4,5,2,3}
 *
 * Second pass - 3 iteration
 * {1,4,5,2,3}
 * {1,2,5,4,3}
 * {1,2,5,4,3}
 *
 *
 * Third pass - 2 iteration
 * {1,2,4,5,3}
 * {1,2,3,5,4}
 *
 * Fourth pass - 1 iteration
 * {1,2,3,4,5}
 *
 * Best case and worst case = O(n^2)
 *
 *
 *
 *
 *
 *
 *
 * */


import java.util.Arrays;

public class SelectionSort {

    public static void selectionSortUnstable(int[] arr) {

        /*length = 5
         *  last element = arr[4]
         *
         *  {1,4,5,2,3}
         *   0,1,2,3,4
         *
         * */

        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    /*Swap*/
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }

    public static void selectionSortStable(int[] arr) {

        int temp;
        int minLocation = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minLocation = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    minLocation = j;
                }
            }
            if (minLocation != i) {
                temp = arr[i];
                arr[i] = arr[minLocation];
                arr[minLocation] = temp;
            }
        }
    }


    public static void main(String[] args) {
        //int[] arr = {1, 4, 5, 2, 3};

        int[] arr = {7, 5, 4, 2};


        selectionSortStable(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }


}
