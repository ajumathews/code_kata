public class MainClass {

    public int divideUnChecked(int num1, int num2){
        if(num2==0){
            throw new RuntimeException();
        }
        return num1/num2;
    }

    public void callUnchecked(){
        divideUnChecked(1,0);
    }

    public int divide(int num1, int num2) throws Exception {
        if (num2 == 0) {
            throw new Exception();
        }
        return num1 / num2;
    }

    public void callChecked() throws Exception {
        divide(1, 0);
    }


}
