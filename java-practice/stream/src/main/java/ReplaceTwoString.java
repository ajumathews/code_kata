import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReplaceTwoString {


    public static void main(String[] args) {

        List<String> comparisonString = Arrays.asList("CTEXC","CTPRF");

        List<String> skuList = Arrays.asList("X", "Y", "CTEXC_NU_IPREG");

        Function<String, String> transformSKU = (s) -> {
            if (s.startsWith("CTEXC")) {
                return "CTEXC";
            }
            if (s.startsWith("CTPRF")) {
                return "CTPRF";
            }
            return s;
        };





        List<String> newSkuList = skuList.stream().map(transformSKU).collect(Collectors.toList());


        skuList.forEach(System.out::println);
        System.out.println("**********");
        newSkuList.forEach(System.out::println);


    }

}
