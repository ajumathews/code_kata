package theory.algorithm.sorting;


import java.util.Arrays;

/*
This algo works only when the array is an integer array and we know the range of integers
We should know the range of inputs

Space time complexity - O(n+k) k is the range of numbers
It largely depends on the range because we need to create a count array based on the range.
If the range is large say - 0-10000 and the number of elements is just 5, then we need to create a massive count array to do that.
So the perfomance is terrible

Counting Sort is generatlly used only if K is not larger than n.

 */
public class CountingSort {

    static int[] countSort(int[] arr) {
        /*Find the max element*/
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        /*Initialize the count array*/
        int[] countArr = new int[max + 1];
        for(int i=0;i<arr.length;i++){
            countArr[arr[i]]++;
        }

        /*Add the consecutive elements in the countArray*/
        for(int i=1;i<countArr.length;i++){
            countArr[i]=countArr[i]+countArr[i-1];
        }


        /*Iterate to the input array and find the positon in the countArray reverse and populate result array */
        int[] result = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            int currentElement=arr[i];
            result[countArr[currentElement]-1]=currentElement;
            countArr[currentElement]--;
        }

        return result;
    }


    public static void main(String[] args) {
        int[] arr = {4,3,2,5,4,3,5,1,0,2,5};
        Arrays.stream(countSort(arr)).forEach(System.out::println);
    }

}
