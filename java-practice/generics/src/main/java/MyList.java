import java.util.ArrayList;
import java.util.List;

public class MyList<T> {

    List<T> list = new ArrayList();

    public void addElement(T s) {
        list.add(s);
    }

    public void removeElement(T s) {
        list.remove(s);
    }

    public String toString(){
       return list.toString();
    }

    public T get(int i) {
        return list.get(i);
    }
}
