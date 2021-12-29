import org.apache.commons.lang3.math.NumberUtils;

import java.text.DecimalFormat;

public class RoundOff {

    public static void main(String[] args) {
        System.out.println(roundValueIfFloat("10000"));
        System.out.println(roundValueIfFloat("0.1000001"));
        System.out.println(roundValueIfFloat("10000.1000001"));
        System.out.println(roundValueIfFloat("Payment Unspecified"));
    }

    public static String roundValueIfFloat(String input) {
        if (NumberUtils.isNumber(input)) {
            DecimalFormat df = new DecimalFormat("0.00");
            return (df.format(NumberUtils.createFloat(input)));
        } else {
            return input;
        }
    }


}
