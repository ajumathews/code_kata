import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {

    public static void main(String[] args) {
        try {
            Class<Test> c = Test.class;
            Test t = c.newInstance();
            Method method = c.getMethod("sayHello");
            method.invoke(t);
            method = c.getMethod("main", String[].class);
            Object[] arr = new Object[1];
            method.invoke(null, arr);
            method = c.getDeclaredMethod("sayHi");
            method.setAccessible(true);
            method.invoke(t);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
