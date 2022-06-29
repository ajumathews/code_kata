import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.w3c.dom.ls.LSOutput;
import reactor.core.publisher.Mono;

public class MonoExtractor {


    private static Mono<String> targetMethod() {
        return Mono.just("Hello world!");
        //return Mono.empty();
    }

    private static void blockingCall() {
        // Null when empty mono
        String result = targetMethod()
                .map(res -> res + " Aju")
                .block();
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
                .block();
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

    private static Mono<String> FlatMapReturn() {

        return targetMethod()
                .flatMap(s -> {
                    System.out.println("Map");
                    s = s.toUpperCase(Locale.ROOT);
                    return Mono.just(s);
                });


    }


    public static void main(String[] args) {
//        blockingCall();
//        nonBlockingCall();

        //nonblockingCallReturn();
        FlatMapReturn().subscribe(System.out::println);
    }


}
