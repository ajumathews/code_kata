package basics;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {
        DemoClass d = new DemoClass();
        d.doSomething();

        Class<DemoClass> demoClass = DemoClass.class;
        for (Field field : demoClass.getFields()) {
            for (Annotation annotation : field.getAnnotations()) {
                if (annotation instanceof FileInfo) {
                    FileInfo fileInfo = (FileInfo) annotation;
                    System.out.println(fileInfo.author());
                    System.out.println(fileInfo.date());
                }
            }
        }
    }
}
