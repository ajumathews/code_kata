package theory;

import com.sun.javafx.util.Logging;

import java.net.URL;
import theory.custom.Test;

public class ClassLoaderExample {


    public static void main(String[] args) {
        System.out.println(ClassLoaderExample.class.getClassLoader());
        System.out.println(Logging.class.getClassLoader());
        System.out.println(Test.class.getClassLoader());

        URL uri = ClassLoaderExample.class.getResource("test.properties");
        System.out.println(uri);

        System.out.println(ClassLoaderExample.class.getClassLoader());
        System.out.println(ClassLoaderExample.class.getClassLoader().getClass().getClassLoader());

        try {
           //Test test= (Test) Logging.class.getClassLoader().loadClass("theory.custom.Test").newInstance();
            Test test= (Test) ClassLoaderExample.class.getClassLoader().loadClass("theory.custom.Test").newInstance();
            test.sayHello();
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
