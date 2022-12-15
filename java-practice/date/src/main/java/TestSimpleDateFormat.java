import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestSimpleDateFormat {

    public static final String FULL_DATE_FORMATE =  "MM/dd/yyyy hh:mm:ss a";
    public static final String inputDateString= "2022072115:43:26.0973";

    public static void main(String[] args) throws ParseException {

        DateFormat inputFormat = new SimpleDateFormat("yyyyMMddHH:mm:ss.SSS");
        Date inputDate = inputFormat.parse(inputDateString);

        DateFormat df = new SimpleDateFormat(FULL_DATE_FORMATE,Locale.US);

        System.out.println(df.format(inputDate));
    }


}
