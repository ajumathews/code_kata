package theory.challenges.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Write a function that takes an non empty array of distinct integers and an integer representing the target Sum
If any two numbers in the input adds up to the target - the function should return those in an array.
If no two numbers add up to the Sum - returns an empty array
Assume that there will be at most one pair which sums up to the target sum.

Inputs - array of distinct integers, sum
Output - If any two numbers adds up to the sum - Return array with those two
       - Empty array if no two numbers adds up to the sum

eg-1 input -  {1,3,4,2,7} , 6
     output - {4,2}


eg-1 input -  {1,3,4,2,7} , 12
     output - {}

* */
public class TwoNumberSum {


    /*
     {1,3,4,2,7} , 6

     First pass
     1,3
     1,4
     1,2
     1,7

     Second pass
     3,4
     3,2
     3,7

     Third pass
     4,2  -- return result

    Time complexity - O(n^2)
    Space complexity - 1
    */
    private static int[] findTwoNumberSumNaive(int[] arr, int sum) {
        int result[] = new int[2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    result[0] = arr[i];
                    result[1] = arr[j];
                    return result;
                }
            }
        }

        return new int[0];
    }


    /*
     {1,3,4,2,7} 6

     Iteration
      i =1
        num to find = 5
        map.contains(5) -false
        map.put(1)

      i=3
        numTofind =3
        map.contains(3) - false
        map.put(3)

     i=4
        numToFind =2
        map.contains(2) - false
        map.put(4)

     i =2
        numToFind = 4
        map.contains(4) - true
        return i, numToFind

        Time Complexity - O(n)
        Space complexity - O(n)

    * */
    private static int[] findTwoNumberSumHashTable(int[] arr, int sum) {
        Map<Integer, Boolean> map = new HashMap<>();
        int numToFind;
        for (int i : arr) {
            numToFind = sum - i;
            if (map.containsKey(numToFind)) {
                return new int[]{i, numToFind};
            } else {
                map.put(i, true);
            }
        }

        return new int[0];
    }


    /*
      {1,3,4,2,7} 6

      Sort the array - n logn
      {1,2,3,4,7}

      left pointer  -1
      right pointer -7
       1+7 = 8 greater than 6 , move right pointer 1 step behind


      left pointer  -1
      right pointer -4
       1+4 = 5 lesser than 6 , move left pointer 1 step ahead

      left pointer  -2
      right pointer -4
       2+4 =6 return


      Time Complexity - O(n log n)
      Space Complexity - O(1)

    */
    private static int[] findTwoNumbersSumSortedArray(int[] arr, int sum) {
        Arrays.sort(arr);

        int leftPointer = 0;
        int rightPointer = arr.length - 1;

        while (leftPointer < rightPointer) {
            if (arr[leftPointer] + arr[rightPointer] == sum) {
                return new int[]{arr[leftPointer], arr[rightPointer]};
            }

            if (arr[leftPointer] + arr[rightPointer] < sum) {
                leftPointer++;
            } else {
                rightPointer--;
            }

        }
        return new int[0];

    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 7};
        int sum = 6;

        Arrays.stream(findTwoNumbersSumSortedArray(arr, sum)).forEach(System.out::println);
    }
}
