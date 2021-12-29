package theory.typeInference;

public class WithoutTypeInference {

    public static void main(String[] args) {
        StringLengthCalculator stringLengthCalculator = (String s) -> s.length();
        printLambda(stringLengthCalculator,"HelloWorld");
    }

    public static void printLambda(StringLengthCalculator calc, String input){
        System.out.println(calc.getLength(input));
    }

    interface StringLengthCalculator {
        int getLength(String s);
    }

}
