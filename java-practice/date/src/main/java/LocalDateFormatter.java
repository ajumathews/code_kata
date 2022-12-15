import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateFormatter {


    public static void main(String[] args) {
        LocalDate localDate = null;

        System.out.println(formatDateTime(localDate));
    }

    private static String formatDateTime(LocalDate localDate) {
        return localDate == null ? null : localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
