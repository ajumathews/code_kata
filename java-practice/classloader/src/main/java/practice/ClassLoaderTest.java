package practice;

public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader c = ClassLoaderTest.class.getClassLoader();
        System.out.println(c.getParent().getParent());
    }
}
