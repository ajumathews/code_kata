import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericMethod {


    <T extends Number> T addAll(List<T> list) {
        Number sum = 0;
        for (T t : list) {
            sum = sum.doubleValue() + t.doubleValue();
        }
        return (T) sum;
    }

    <T extends List> void doubleList(T list) {
        list.addAll(list);
    }


    public static void main(String[] args) {

        GenericMethod g = new GenericMethod();
        System.out.println(g.addAll(Arrays.asList(1, 3, 4)));

        List<String> names = new ArrayList<>();
        names.add("aju");
        names.add("anju");
        g.doubleList(names);
        System.out.println(names.toString());

    }
}
