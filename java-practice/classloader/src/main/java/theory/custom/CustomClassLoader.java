package theory.custom;

import java.io.*;
import java.net.URL;

public class CustomClassLoader extends ClassLoader {

    public void sayHello(){
        System.out.println("Hello");
    }

    public Class findClass(byte[] b , String name) throws ClassNotFoundException {
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassFromFile(String fileName) {
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            InputStream inputStream = new FileInputStream(fileName);

            while ((nextValue = inputStream.read()) != -1) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class klass = CustomClassLoader.class;
        URL location = klass.getResource('/' + klass.getName().replace('.', '/') + ".class");

        CustomClassLoader c = new CustomClassLoader();
         byte[] b = c.loadClassFromFile("C:\\Aju\\Learning\\code_kata\\java-practice\\classloader\\target\\classes\\theory.custom\\CustomClassLoader.class");
        //byte[] b = c.loadClassFromFile("C:\\Aju\\Learning\\code_kata\\java-practice\\classloader\\target\\classes\\theory.custom\\Test.class");

        Class<CustomClassLoader> custom =c.findClass(b,"theory.custom.CustomClassLoader");
        CustomClassLoader c2 =  custom.newInstance();
        c2.sayHello();

    }

}
