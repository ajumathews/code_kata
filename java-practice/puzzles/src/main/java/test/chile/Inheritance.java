package test.chile;

public class Inheritance {

    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        System.out.println(a.c +" "+a.getValue() );
        System.out.println(b.getValue() +" "+b.getSuperValue() );

    }
}



class A{
    protected char c='A';

    char getValue(){
        return c;
    }

}

class B extends  A{
    protected  char c ='B';

    char getValue(){
        return c;
    }

    char getSuperValue(){
        return super.c;
    }


}