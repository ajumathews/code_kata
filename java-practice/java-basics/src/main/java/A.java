import jdk.nashorn.internal.parser.JSONParser;

public class A {

    void draw(){
        System.out.println("A");

    }



}

class B extends A{

    void draw(){
        System.out.println("B");
    }

    void eat(){
        System.out.println("eat");
    }
}

class Main{
public static void main(String[]args){


        A b = new B();
        b.draw();
        b.eat();

}



}
