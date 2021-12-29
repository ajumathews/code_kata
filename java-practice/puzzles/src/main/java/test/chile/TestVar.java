package test.chile;

public class TestVar {

    public static void main(String[] args) {
        int v1= 5;
        int v2 = 6;

        if((v2=1)==v1){
            System.out.println(v2);
        }else{
            System.out.println(++v2);
        }
    }
}
