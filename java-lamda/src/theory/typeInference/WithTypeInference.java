package theory.typeInference;

/*
Because the compiler already knows the type of the lamda , we dont need to pass the type of the arguments and
can remove the parenthesis.

* */
public class WithTypeInference {

    public static void main(String[] args) {
       printLambda(s->s.length(),"hello world");
    }

    public static void printLambda(StringLengthCalculator calc, String input){
        System.out.println(calc.getLength(input));
    }

    interface StringLengthCalculator {
        int getLength(String s);
    }

}
