package test.chile;

public class Base {

    final public void show(){
        System.out.println("Base");
    }
}


class Derived extends  Base{
/*
    public void show(){
        System.out.println("Derived");
    }*/

}

class Main{

    public static void main(String[] args) {
        Base b = new Derived();
        b.show();
    }
}