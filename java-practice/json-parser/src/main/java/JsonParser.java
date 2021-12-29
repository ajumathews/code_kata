import com.google.gson.Gson;

import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class JsonParser {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("C:\\Aju\\Learning\\code_kata\\java-practice\\json-parser\\src\\main\\resources\\customizedConfig.json"));
        StringBuilder sb = new StringBuilder();
        while(scanner.hasNext()){
            sb.append(scanner.nextLine());
        }
        System.out.println(sb.toString());

        Gson gson = new Gson();
        Map response = gson.fromJson(sb.toString(), Map.class);
        System.out.println(response.size());

    }
}
