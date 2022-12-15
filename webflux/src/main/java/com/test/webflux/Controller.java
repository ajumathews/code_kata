package com.test.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class Controller {

    private final WebClient webClient;

    public Controller(WebClient.Builder webClientBuilder) {
        webClientBuilder.build();
        this.webClient = webClientBuilder.build();
    }


    @GetMapping()
    public Mono<String> invokeSubscriptionApiReturnAsync() {
        WebClient.ResponseSpec responseSpec = webClient.get()
                .uri("localhost:8080/v1/subscription/products")
                .retrieve();

        return responseSpec.bodyToMono(String.class);
    }
}
