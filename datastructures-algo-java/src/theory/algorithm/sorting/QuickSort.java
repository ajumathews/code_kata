package theory.algorithm.sorting;


import java.util.Arrays;


/*
 {4,8,2,1,5,7,6,3}
  0,1,2,3,4,5,6,7

  pivot = 4
  swapidx=0
  4,8,2,1,5,7,6,3

  swapIdx=1
  4,2,8,1,5,7,6,3

  swapIdx=2
  4,2,1,8,5,7,6,3

   swapIdx=3
  4,2,1,3,5,7,6,8

final swap of the pivot to the swapidx and returns the pivot
  3,2,1,4,5,7,6,8

 Now we got the pivot we will do the same operations recursively to the left and right side of the pivot

 {3,2,1,4,5,7,6,8}

 {3,2,1}    {5,7,6,8}

Time complexity of best and average case is O(n logn)
Worst case is when the array is almost sorted and we are picking the pivot as the first element.
Then we have to do O(n) decompositions and O(n) comparisons . So O(n^2)

To avoid that we can pick the pivot as a random number



* */

public class QuickSort {


    static void quickSort(int[] arr, int start, int end) {
        if (start < end) {

            //find the pivot and shift the elements greater than to the right side of the array ane less than to the left side
            int pivotIndex = pivot(arr, start, end);

            //left
            quickSort(arr, start, pivotIndex - 1);

            //right
            quickSort(arr, pivotIndex + 1, end);
        }
    }


    static int pivot(int[] arr, int start, int end) {
        int swapIndex = start;
        int pivot = arr[start];
        int temp;

        for (int i = start+1; i <= end; i++) {
            if (arr[i] < pivot) {
                swapIndex++;
                temp = arr[i];
                arr[i] = arr[swapIndex];
                arr[swapIndex] = temp;
            }
        }

        temp = arr[start];
        arr[start] = arr[swapIndex];
        arr[swapIndex] = temp;
        return swapIndex;
    }


    public static void main(String[] args) {
        int[] arr = {4, 8, 2, 1, 5, 7, 6, 3};
        quickSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }


}
