class CustomCheckedException extends Exception {}
class CustomUnCheckedException extends RuntimeException {}
class CustomThrowAble extends Throwable {}



public class CustomException {

    public int divide(int num1, int num2) throws CustomCheckedException {
        if (num2 == 0) {
            throw new CustomCheckedException();
        }
        return num1 / num2;
    }

    public int divideUnchecked(int num1, int num2) {
        if (num2 == 0) {
            throw new CustomUnCheckedException();
        }
        return num1 / num2;
    }

    public int divideThrowable(int num1, int num2) throws CustomThrowAble {
        if (num2 == 0) {
            throw new CustomThrowAble();
        }
        return num1 / num2;
    }

}
