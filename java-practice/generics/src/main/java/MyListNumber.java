import java.util.ArrayList;
import java.util.List;

public class MyListNumber<T extends Number> {

    List<T> list = new ArrayList();

    public T sumOfElements() {
        Number sum = 0;
        for (Number n : list) {
            sum = sum.doubleValue() + n.doubleValue();
        }
        return (T) sum;
    }

    public void add(T num){
        list.add(num);
    }

}
