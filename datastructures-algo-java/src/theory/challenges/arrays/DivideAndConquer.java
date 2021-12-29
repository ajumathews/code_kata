package theory.challenges.arrays;


/*
* Given a sorted array, return the index of the element
*
* input- sorted array , int
* output - int
* {1,2,3,4}, 4 -> 3
* {1,2,3,4}, 2 ->1
*
* */
public class DivideAndConquer {

    public int findIndexNaive(int[] arr,int value){
        int index=-1;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==value){
                    return i;
                }
            }

        return index;
    }

    public int findIndex(int[] arr,int value){
        int index=-1;



        return index;
    }




    public static void main(String[] args) {
        DivideAndConquer divideAndConquer= new DivideAndConquer();

        int[] arr= {1,2,3,4};
        int value=4;


        System.out.println(divideAndConquer.findIndexNaive(arr,value));
    }


}
