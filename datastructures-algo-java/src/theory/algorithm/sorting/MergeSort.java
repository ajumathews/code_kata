package theory.algorithm.sorting;

import java.util.Arrays;


/*
*     {1, 4, 5, 2}
*
*     {1,4}  {5,2}
*
*  {1}{4}     {5},{2}
*
*     {1,4} {2,5}
*
*      {1,2,4,5}
*
*
*   Best and Worst Time complexity - O(nlogn)
*   Space Complexity - O(n)
*
*   n- because we are traversing n times
*   logn - for the number of splitting required
*
*
*
* */

public class MergeSort {

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            leftArray[i] = arr[i];
        }

        for (int i = mid,j=0; i < arr.length; i++,j++) {
            rightArray[j] = arr[i];
        }

        return merge(mergeSort(leftArray), mergeSort(rightArray));

    }

    static int[] merge(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length + rightArray.length];

        int i, j, k;

        for (i = 0, j = 0, k = 0; i < leftArray.length && j < rightArray.length; k++) {

            if (leftArray[i] < rightArray[j]) {
                result[k] = leftArray[i];
                i++;
            } else {
                result[k] = rightArray[j];
                j++;
            }

        }
        while (i < leftArray.length) {
            result[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length) {
            result[k] = rightArray[j];
            j++;
            k++;
        }

        return result;
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 3};
        Arrays.stream(mergeSort(arr)).forEach(System.out::println);
    }

}
