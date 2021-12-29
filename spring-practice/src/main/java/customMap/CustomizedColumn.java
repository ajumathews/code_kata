package customMap;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class CustomizedColumn {

    private Map customizedColumn;

    public void onLoad() throws IOException {
        Scanner scanner = new Scanner(new File(
                "C:\\Aju\\Learning\\code_kata\\spring-practice\\src\\main\\resources\\customizedConfig.json"
        ));
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
        }
        System.out.println(sb.toString());

        Gson gson = new Gson();
        customizedColumn = gson.fromJson(sb.toString(), Map.class);

    }

    public Map getCustomizedColumn() {
        return customizedColumn;
    }
}
