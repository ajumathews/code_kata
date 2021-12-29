package theory.challenges.arrays;



/*
 *  Find Max Sum of the consecutive numbers
 *   input  = array , number
 *   output = array
 *
 *   Examples
 *   [1,2,3,4,1,5], 2  == > 3, 4
 *   [1,2,3,1] ,1 ==> 3
 *   [1,2,3,4,5],4 ==>  [2,3,4,5]
 *
 *   Sliding Window Pattern
 *
 *
 * */

public class MaxSubArray {

    public int[] findMmaxSumNaive(int[] arr, int num) {

        if (arr.length == 0 || num == 0) {
            return null;
        }

        int[] result = new int[num];

        int maxSum = 0;
        int maxSumArrayStartIndex = 0;

        for (int i = 0; i <= arr.length - num; i++) {
            int currentSum = 0;
            for (int j = i; j < i + num; j++) {
                currentSum = currentSum + arr[j];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxSumArrayStartIndex = i;
            }
        }


        for (int i = 0, j = maxSumArrayStartIndex; i < num; i++, j++) {
            result[i] = arr[j];
        }


        return result;
    }


    public int findMmaxSum(int[] arr, int num) {

        if (arr.length == 0 || num == 0) {
            return 0;
        }

        int maxSum=0;


        for(int i=0;i<num ;i++){
            maxSum=maxSum+arr[i];
        }
        int currentSum=maxSum;
        for(int i=num;i<arr.length;i++){
            currentSum= currentSum+ arr[i]-arr[i-num];
            if(currentSum>maxSum){
                maxSum=currentSum;
            }
        }

        return maxSum;
    }


    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }



    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();

/*        int[] arr = {};
        int num = 0;*/

/*        int[] arr = {1, 2, 3, 4, 1, 5};
        int num = 2;*/

/*        int[] arr = {1, 2, 3, 4, 1, 5};
        int num = 3;*/

/*
        int[] arr = {1, 2, 3, 1};
        int num = 1;
*/

        int[] arr = {1, 2, 3, 4, 5};
        int num = 4;

/*        int[] result = maxSubArray.findMmaxSumNaive(arr, num);
        if (result != null) {
            Arrays.stream(result).forEach(i -> System.out.println(i));
        }*/

        System.out.println(maxSubArray.findMmaxSum(arr,num));

        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }
}
