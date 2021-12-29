package theory.challenges.arrays;


//Understanding
//Given a sorted array, find the first pair which summs to zero

//Input - array
//Output - array

//input : [-3,-2,1,2,5] ==> [-2,2]
//input :[-3,1,2,1] ==> no result


import java.util.Arrays;

public class MultiplePointer {

    public int[] multiplePointerNaive(int[] arr) {
        int[] result = new int[2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 0) {
                    result[0] = arr[i];
                    result[1] = arr[j];
                }
            }
        }

        return result;
    }


    public int[] multiplePointer(int[] arr) {
        int[] result = new int[2];

        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[leftIndex] + arr[rightIndex] == 0) {
                result[0] = arr[leftIndex];
                result[1] = arr[rightIndex];
                return result;
            } else if (arr[leftIndex] + arr[rightIndex] > 0) {
                rightIndex--;
            } else if (arr[leftIndex] + arr[rightIndex] < 0) {
                leftIndex++;
            }


        }

        return result;
    }

    public static void main(String[] args) {
        MultiplePointer multiplePointer = new MultiplePointer();

        //int[] arr={-2,-1,0,2};
        int[] arr = {-3, -2, -1, 0, 2, 4, 5};

        Arrays.stream(multiplePointer.multiplePointer(arr)).filter(i -> i != 0).forEach(i -> System.out.println(i));
    }
}
