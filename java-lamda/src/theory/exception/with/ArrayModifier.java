package theory.exception.with;

import java.util.function.BiConsumer;

/*
We can handle the theory.exception inline like divideInlineException

Or we can create a wrapper lambda which handles the theory.exception.

* */
public class ArrayModifier {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int key =0;

       //Multiply all array elements by key
        BiConsumer<Integer,Integer> multiply = (i,k)-> System.out.println(i*k);

        BiConsumer<Integer,Integer> divide = (i,k)-> System.out.println(i/k);


        BiConsumer<Integer,Integer> divideInlineException = (i,k)-> {
            try{
                 System.out.println(i/k);
            }catch (ArithmeticException e){
                System.out.println(e.toString());
            }
        };

        BiConsumer<Integer,Integer> divideWithExceptionHandler = handleException(divide);


        process(arr,key,divideWithExceptionHandler);

    }

    private static void process(int[] arr, int key, BiConsumer<Integer,Integer> consumer){
        for(int i:arr){
            consumer.accept(i,key);
        }
    }

    private static BiConsumer<Integer,Integer> handleException(BiConsumer<Integer,Integer> consumer){
        return (i,k)->{
            try{
                consumer.accept(i,k);
            }catch (ArithmeticException e){
                System.out.println(e.toString());
            }
        };
    }
}
