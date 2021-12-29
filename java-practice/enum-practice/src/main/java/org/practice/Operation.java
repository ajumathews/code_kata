package org.practice;

public enum Operation {
    ADD,
    SUB;

    int calculate(int a, int b) {
        switch (this) {
            case ADD:
                return a + b;
            case SUB:
                return a - b;
            default:
                throw new RuntimeException("No such operation");
        }
    }
}

class Runner{
    public static void main(String[] args) {
        System.out.println(Operation.ADD.calculate(1,2));
        System.out.println(Operation.SUB.calculate(1,2));

    }
}