package theory.challenges.number;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FindNextHighestNumber {


    public int[] nextHighest(int[] arr) {
        /*
        218765
        251678
        698765
        */

        int breakingIndex = 0;

        // Iterate to find the breaking number
        for (int i = arr.length - 1; i > 0; i--) {

            if (arr[i] > arr[i - 1]) {
                breakingIndex = i - 1;
                break;
            }

        }


        // Swap the breaking number with the next highest number towards the right side
        // 698765

        int temp = 0;
        for (int i = arr.length - 1; i > breakingIndex; i--) {
                if (arr[i] > arr[breakingIndex]) {
                //swap

                temp = arr[i];
                arr[i] = arr[breakingIndex];
                arr[breakingIndex] = temp;
                break;
            }

        }
        // 798665

        // Sort the remaining part from breakindex

        Arrays.sort(arr, breakingIndex + 1, arr.length);

        return arr;
    }

    @Test
    public void test1() {
        int[] array = {1, 2, 3, 4};
        Assert.assertArrayEquals(new int[]{1, 2, 4, 3}, nextHighest(array));
    }

    @Test
    public void test2() {
        int[] array = {6, 9, 8, 7, 6, 5};
        Assert.assertArrayEquals(new int[]{7, 5, 6, 6, 8, 9}, nextHighest(array));
    }


}
