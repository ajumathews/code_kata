package theory.algorithm.sorting;

/*
 * {2,5,3,1,4,6,-1}
 *
 * gap = 7/2 = 3
 *
 * Preliminary Sort
 *
 * First pass
 * {2,5,3,1,4,6,-1}  val = 1
 * {2,5,3,2,4,6,-1}
 * {1,5,3,2,4,6,-1}
 *
 * Second pass - val =4
 * {1,5,3,2,5,6,-1}
 * {1,4,3,2,5,6,-1}
 *
 * Third pass- val =6
 * {1,4,3,2,5,6,-1}
 *
 * Fourth pass - val =-1
 * {1,4,3,2,5,6,2}
 * {1,4,3,1,5,6,2}
 * {-1,4,3,1,5,6,2}
 *
 * Gap = 1 - preliminary sorting is done
 * Do insertion Sort
 *
 * First pass
 * {-1,4,3,1,5,6,2} val =4
 *
 * Second pass
 * {-1,4,4,1,5,6,2} - val =3
 * {-1,3,4,1,5,6,2}
 *
 *  Third pass
 *  {-1,3,4,4,5,6,2} val= 1
 *  {-1,3,3,4,5,6,2}
 *  {-1,1,3,4,5,6,2}
 *
 *  Fourth pass -val =5
 *  {-1,1,3,4,5,6,2}
 *
 *  Fifth pass -val =6
 *  {-1,1,3,4,5,6,2}
 *
 *  Sixth pass -val =2
 *  {-1,1,3,4,5,6,6}
 *  {-1,1,3,4,5,5,6}
 *  {-1,1,3,4,4,5,6}
 *  {-1,1,3,3,4,5,6}
 *  {-1,1,2,3,4,5,6}
 *
 *
 *  Time Complexity
 *  Can perform better than insertion sort since it does less shifting
 *  Worst case = O(n^2)
 *
 * */


import java.util.Arrays;

public class ShellSort {


    public static void shellShort(int[] arr) {

        /*Preliminary Sort*/
        for (int gap = arr.length / 2; gap > 1; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j;
                int currentValue = arr[i];
                for (j = i; j > 0 && arr[j - gap] > currentValue; j = j - gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = currentValue;
            }
        }

        /*Now Gap is reduced to 1 so do insertion sort*/
        insertionSort(arr);
    }


    public static void insertionSort(int[] arr) {

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
        int[] arr = {19, 10, 8, 17, 9};
        insertionSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }


}
