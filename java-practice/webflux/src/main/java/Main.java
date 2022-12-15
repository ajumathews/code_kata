import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

public class Main {


    public static void main(String[] args) {


        //WebClient webClient = WebClient.create();

       WebClient webClient =  WebClient.builder().exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer
                                .defaultCodecs()
                                .maxInMemorySize(2 * 1024 * 1024))
                        .build())
                .build();

//        WebClient.ResponseSpec responseSpec = webClient.get()
//                .uri("localhost:8080/v1/subscription/products")
//                .retrieve();


        WebClient.ResponseSpec responseSpec = webClient.get()
                .uri("localhost:8080/v1/subscription/product/8ac6979780d1a2e10180d37e5b0572b9")
                .retrieve();


        String responseBody = responseSpec.bodyToMono(String.class).block();
        System.out.println(responseBody);

    }
}
