package practice;

public class A {

 void drink(){

 }



    void eat(){

    }

}

class B extends A {

    void drink(){

    }
}


class Main(){

public static void main(String[]args){

    A a = new B();
    a.drink();

    a.eat();
  }
}