import java.util.Base64;

public class EncodeDecode {

    public static void main(String[] args) {

        String svgExtractApiKey = "cortellisApiUser";
       String encodedString =  Base64.getEncoder().withoutPadding().encodeToString(svgExtractApiKey.getBytes());
        System.out.println(encodedString);

    }
}
