package theory.recursion;

import java.util.Arrays;

public class HelperMethodRecursion {

    private int[] collectOddNumbers(int[] inputArray) {
        int[] oddArray = new int[inputArray.length];
        return findOdd(inputArray, oddArray, 0, 0,inputArray.length);
    }

    private int[] findOdd(int[] inputArray, int[] oddArray, int index,int oddArrayIndex, int end) {
        if (index == end) {
            return oddArray;
        }
        if (inputArray[index] % 2 != 0) {
            oddArray[oddArrayIndex] = inputArray[index];
            oddArrayIndex++;
        }
        index++;
        return findOdd(inputArray, oddArray, index,oddArrayIndex, end);
    }


    public static void main(String[] args) {
        HelperMethodRecursion helperMethodRecursion = new HelperMethodRecursion();

        int[] inputArray = {1, 2, 3, 4, 5, 6};
        Arrays.stream(helperMethodRecursion.collectOddNumbers(inputArray)).forEach(i -> System.out.println(i));
    }

}
