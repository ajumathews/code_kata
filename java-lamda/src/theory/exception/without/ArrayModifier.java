package theory.exception.without;

import java.util.function.BiConsumer;

/*
Here when we pass divide lambda, we get theory.exception
* */
public class ArrayModifier {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int key =0;

       //Multiply all array elements by key
        BiConsumer<Integer,Integer> multiply = (i,k)-> System.out.println(i*k);

        BiConsumer<Integer,Integer> divide = (i,k)-> System.out.println(i/k);


        process(arr,key,divide);

    }

    private static void process(int[] arr, int key, BiConsumer<Integer,Integer> consumer){
        for(int i:arr){
            consumer.accept(i,key);
        }
    }
}
