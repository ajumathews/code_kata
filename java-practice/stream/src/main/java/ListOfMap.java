import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfMap {

    public static void main(String[] args) {
        List<Map<String,String>> response = new ArrayList<>();
        Map<String, String> m1 = new HashMap<>();
        m1.put("drugId","12135");
        Map<String, String> m2 = new HashMap<>();
        m2.put("drugId","6619");

        response.add(m1);
        response.add(m2);

        List<String> drugs = new ArrayList<>();
        response.stream().forEach(m-> drugs.add(m.get("drugId")));

        drugs.forEach(d-> System.out.println(d));
    }

}
