import com.google.gson.Gson;
import org.json.JSONObject;

import java.util.*;

public class JsonStringConverter {


    public static void main(String[] args) {
        Map<Object, Object> emp = new LinkedHashMap<>();
     /*   emp.put("aju", "Aju");*/
        List<String> roles = new ArrayList<>();
        roles.add("dev");
        emp.put("roles",roles);

/*        Gson gson = new Gson();
       String jsonString=  gson.toJson(emp);*/

        JSONObject json = new JSONObject(emp);

        System.out.println(json.toString());

    }
}
