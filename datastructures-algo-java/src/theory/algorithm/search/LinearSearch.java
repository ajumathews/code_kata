package theory.algorithm.search;

public class LinearSearch {


    private static int indexOf(String[] arr, String value){
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] arr= {"aju","anju","pavan","babu","sarin"};
        System.out.println(indexOf(arr,"aju"));
    }
}
