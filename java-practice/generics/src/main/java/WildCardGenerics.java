import java.util.Arrays;
import java.util.List;

public class WildCardGenerics {


    public Number sumOf(List<? extends Number> numbers){
        Number sum =0;
        for(Number number :numbers){
            sum= sum.doubleValue()+ number.doubleValue();
        }
        return sum;
    }


    public static void main(String[] args) {

        WildCardGenerics wildCardGenerics = new WildCardGenerics();
        System.out.println(wildCardGenerics.sumOf(Arrays.asList(1,2,3)));
        System.out.println(wildCardGenerics.sumOf(Arrays.asList(1.2,2.3,3.6)));
    }

}
