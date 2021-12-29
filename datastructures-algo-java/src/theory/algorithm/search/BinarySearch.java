package theory.algorithm.search;

public class BinarySearch {


    private static int indexOf(int[] arr, int value) {
        int start = 0;
        int end = arr.length - 1;
        int midpoint;

        while (start < end) {
            midpoint = (start + end) / 2;
            if (value == arr[midpoint]) {
                return midpoint;
            } else {
                if (value < arr[midpoint]) {
                    end = midpoint - 1;
                } else {
                    start = midpoint + 1;
                }
            }
        }
        return -1;
    }

    private static int indexOfRecursively(int[] arr, int value){
        return  recursiveBinarySearch(0,arr.length-1,arr,value);
    }


    private static int recursiveBinarySearch(int start, int end, int[] arr, int value) {
        if (start == end) {
            return -1;
        } else {
            int midpoint = (start + end) / 2;
            if (value == arr[midpoint]) {
                return midpoint;
            } else {
                if (value < arr[midpoint]) {
                    end = midpoint - 1;
                } else {
                    start = midpoint + 1;
                }
               return recursiveBinarySearch(start, end, arr, value);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 10, 22, 29};
/*
        System.out.println(indexOf(arr, 6));
        System.out.println(indexOf(arr, 22));
*/

        System.out.println(indexOfRecursively(arr, 6));
        System.out.println(indexOfRecursively(arr, 22));

    }
}
