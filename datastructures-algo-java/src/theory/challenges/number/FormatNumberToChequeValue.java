package theory.challenges.number;

import org.junit.Assert;
import org.junit.Test;

public class FormatNumberToChequeValue {


    /*
     1234
     1234/10 = 4
     123/10 = 3
     12/10 = 2
     1/10= 1
    * */

    /*
     1000
     1,000

     1 0 0 0 0 0
     100,000
    * */
    public static String format(int number) {
        StringBuilder sb = new StringBuilder();

        for(int i=number, j=0; i>0; i=i/10,j++){
            if(j!=0 && j%3 ==0){
                sb.append(",");
            }
            sb.append(i%10);
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("10,000",format(10000));
        Assert.assertEquals("1,000",format(1000));
    }
}
