package theory.recursion;

public class Factorial {


    public int findFactorialNaive(int num){
        int factorial=1;
        for(int i=num;i>0;i--){
            factorial=factorial*i;
        }
        return factorial;
    }


    public int findFactorial(int num){
        if(num==1){
            return 1;
        }
        return num * findFactorialNaive(num-1);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.findFactorial(3));
    }

}


