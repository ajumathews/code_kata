package theory.challenges.number;

import org.junit.Assert;
import org.junit.Test;

public class NumberToString {


    /*
     1234
     1234/10 = 4
     123/10 = 3
     12/10 = 2
     1/10= 1
    * */
    public static String convert(int number){
        StringBuilder sb = new StringBuilder();

        for(int i=number; i>0; i=i/10){
            sb.append(i%10);
        }
        return sb.reverse().toString();
    }


    @Test
    public void test() {
        Assert.assertEquals("1000", convert(1000));
        Assert.assertEquals("1234", convert(1234));
    }
}
