package theory.algorithm.sorting;

/*
 * {2,5,3,1,4}
 *
 * First Pass -- val =5
 * {2,5,3,1,4}
 *
 * Second pass - val=3
 * {2,5,5,1,4}
 * {2,3,5,1,4}
 *
 * Third pass - val =5
 * {2,3,5,1,4}
 *
 * Fourth pass -val =1
 * {2,3,5,5,4}
 * {2,3,3,5,4}
 * {2,2,3,5,4}
 * {1,2,3,5,4}
 *
 * Fifth pass - val =4
 * {1,2,3,5,5}
 * {1,2,3,4,5}
 *
 *
 *
 *  Time Complexity
 *  Best case = O(n)
 *  Worst case = O(n^2)
 *
 * */


import java.util.Arrays;

public class InsertionSort {

     static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > currentValue; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = currentValue;
        }
    }


    public static void main(String[] args) {
        // int[] arr = {1, 4, 5, 2, 3};

        int[] arr = {19, 10, 8, 17, 9};
        insertionSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }


}
