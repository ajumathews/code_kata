import java.util.Map;

public class Test {

    private Map<String, Integer> _printClickCountByDomain(String[] counts) {

        


    }

    private static void printClickCountByDomain() {
        // input of counts,domain
        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };

        // Your Challenge is to provide total count by domain.
        // Here, Domain need to be broken into sub domains and then counted.
        // Ex: the domain 'google.co.uk becomes' will become: 'google.co.uk', 'co.uk', 'uk'
        Map<String, Integer> countMap = _printClickCountByDomain(counts);

        // expected output
        // [com] => [1345]
        // [stackoverflow.com] => [10]
        // [sports.yahoo.com] => [50]
        // [google.com] => [900]
        // [sports] => [1]
        // [org] => [3]
        // [wikipedia.org] => [3]
        // [mobile.sports] => [1]
        // [mail.yahoo.com] => [60]
        // [en.wikipedia.org] => [2]
        // [mobile.sports.yahoo.com] => [10]
        // [uk] => [1]
        // [yahoo.com] => [410]
        // [com.com] => [5]
        // [m.wikipedia.org] => [1]
        // [google.co.uk] => [1]
        // [co.uk] => [1]
        // [overflow.com] => [20]
        for (String key : countMap.keySet()) {
            System.out.println(String.format("[%s] => [%d]\n", key, countMap.get(key)));
        }
    }

}
