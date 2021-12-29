package practice;

public class RecursiveBinarySearch {

    /*
     {1, 3, 5, 8, 10, 22, 29};
      ^                    ^
    * */
    public static void search(int[] arr, int start, int end, int value){
        int midPoint = start + end / 2;

        if(arr[midPoint] == value){
           // return midPoint;
        } else{
            if(value < midPoint){
                end = midPoint - 1;
            } else{
                start = midPoint + 1;
            }
            //return search()
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 10, 22, 29};


       // System.out.println(search(arr,0, arr.length -1, 8));
    }
}
