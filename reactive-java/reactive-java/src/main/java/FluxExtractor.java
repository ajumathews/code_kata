import java.util.ArrayList;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxExtractor {


    private static Flux<String> targetMethod() {
        return Flux.just("Hello", "world!");
        //return Mono.empty();
    }

    private static void blockingCall() {
        // Null when empty mono
        String result = targetMethod()
                .map(res -> res + " Aju")
                .blockLast();
        System.out.println(result);
    }

    private static void nonBlockingCall() {
        // Not null when empty mono
        targetMethod()
                .map(res -> res + " Aju")
                .subscribe(res -> System.out.println(res));
    }


    private static String blockingCallReturn() {
        // Null when empty mono
        String result = targetMethod()
                .map(res -> res + " Aju")
                .blockLast();
        return result;
    }

    private static List<String> nonblockingCallReturn() {
         final List<String> response = new ArrayList<>();

        targetMethod()
                .doOnNext(s->{
                    System.out.println("do on Next");
                    response.add(s);
                })
                .map(s -> {
                    System.out.println("Map");
                    int i = 1/0;
                    return 1;
                })
                .onErrorReturn(10)
                .doAfterTerminate(()->{
                    System.out.println("doAfterTerminate");
                })
                .doFinally(s->{
                    System.out.println(" doFinally" );
                })
                .subscribe(
                        res -> {
                            System.out.println("on Next in subscribe " + res );
                        },
                        throwable -> {
                            System.out.println("throwable " + throwable);
                        },
                        () ->   {
                            System.out.println("completed in subscribe");
                        });

        return response;
    }

    private static Mono<List<String>> flatMapReturnReduce() {

        return targetMethod()
                .map(s->s.toUpperCase())
                .reduce(new ArrayList<String>(),
                        (x1, x2)-> {
                            x1.add(x2);
                           return x1;
                        }
                );
    }

    private static Flux<String> flatMapReturn() {

        return targetMethod()
        //        .flatMap(s-> Mono.just(s.toUpperCase()));
                .flatMap(s-> Mono.just(s.toUpperCase()));
    }



    public static void main(String[] args) {
//        blockingCall();
//        nonBlockingCall();

        //nonblockingCallReturn();
      // flatMapReturnReduce().subscribe(s->s.forEach(System.out::println));
    flatMapReturn().subscribe(System.out::println);

    }


}
