package theory.methodReference;
/*
Here in the lambda we are calling a method without any parameter
so this can be replace by the method reference
* */
public class Example1 {

    public static void main(String[] args) {
        Thread t = new Thread(()->print());
        t.start();

        t = new Thread(Example1::print);

    }


    private static void print(){
        System.out.println("hello world");
    }
}
