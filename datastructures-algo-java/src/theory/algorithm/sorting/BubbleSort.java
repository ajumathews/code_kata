package theory.algorithm.sorting;

/*
 * {1,4,5,2,3}
 *
 *  First pass - 4 iterations
 *  {1,4,5,2,3}
 *  {1,4,5,2,3}
 *  {1,4,2,5,3}
 *  {1,4,2,3,5}
 *
 *  Second pass - 3 iteration - -here the array becomes sorted
 *  {1,4,2,3,5}
 *  {1,2,4,3,5}
 *  {1,2,3,4,5}
 *
 *  Third pass : if there is no swap then the array is sorted. Iteration ends
 *  {1,2,3,4,5}
 *
 *  Time Complexity
 *  Best case : O(n)
 *  Worst case : O(n^2)
 * */


import java.util.Arrays;

public class BubbleSort {


    public static void bubbleSort(int[] arr) {

        /*
         *  {1,4,5,2,3}
         *   0,1,2,3,4
         *
         *   length = 5
         *   arr[4] is the last element
         *
         * */

        int temp;
        boolean noSwaps;

        for (int itr = arr.length-1; itr >0; itr--) {
            noSwaps = true;
            for (int i = 0; i < itr; i++) {
                if (arr[i] > arr[i + 1]) {
                    noSwaps = false;
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }

            if (noSwaps) {
                break;
            }
        }


    }


    public static void main(String[] args) {
       // int[] arr = {1, 4, 5, 2, 3};

        int[] arr={19, 10, 8, 17, 9};
        bubbleSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }


}
