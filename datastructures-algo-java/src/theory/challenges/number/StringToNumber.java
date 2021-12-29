package theory.challenges.number;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StringToNumber {

    /*
    1234
    4*1 = 4
    3*10  30
    2*100 =200
    1*1000 = 1000
    * */
    public static int convert(String number) {
        int output = 0;
        Map<String, Integer> characterIntegerMap = new HashMap<>();
        for(int i =0 ;i<10; i++){
            characterIntegerMap.put(""+i, i);
        }

        for (int i = number.length() - 1, multiplier = 1; i >= 0; i--) {
            int numberAtIndex = multiplier * characterIntegerMap.get(""+number.charAt(i));
            output += numberAtIndex;
            multiplier *= 10;
        }
        return output;
    }


    @Test
    public void test() {
        Assert.assertEquals(1000, convert("1000"));
        Assert.assertEquals(1234, convert("1234"));
    }
}
