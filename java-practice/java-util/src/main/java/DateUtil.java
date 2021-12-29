import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {


    static String simpleDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
       return formatter.format(date);
    }

    static String dateTimeFormatter(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.now().format(formatter);
    }

    public static void main(String[] args) {

       // System.out.println(dateTimeFormatter());
        System.out.println(convertDateToFormat("2020-05-26"));
    }


    static String convertDateToFormat(String inputDate){
        DateTimeFormatter f = DateTimeFormatter.ofPattern( "yyyy-MM-dd");
        LocalDate ld = LocalDate.parse( inputDate );
        return inputDate;
    }
}
