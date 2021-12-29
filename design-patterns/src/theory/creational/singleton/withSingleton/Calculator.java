package theory.creational.singleton.withSingleton;

public class Calculator {

    private static Calculator calculator;

    private Calculator(){}

    public static Calculator getInstance(){
        if(calculator==null){
            calculator = new Calculator();
        }
        return calculator;
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }
}
