import java.util.ArrayList;
import java.util.List;
import reactor.core.publisher.Mono;

public class ListOfMonoToMono {


    public static void main(String[] args) {

        List<String> offers = new ArrayList<>();
        offers.add("aju");
        Mono<List<String>> results = Mono.just(offers);

        Mono<String> offer = results.flatMap(v -> Mono.just(v.stream().findFirst().orElse(null)));
        offer.subscribe(System.out::println);


    }
}
