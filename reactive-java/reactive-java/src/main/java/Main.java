import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.w3c.dom.ls.LSOutput;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Main {


    private static void simple() {

        Mono<Integer> resourSDKResponse = Mono.just(1);


       int responsse =   resourSDKResponse.block();
        System.out.println(responsse);

    }


    private static void withSubscriberInterface() {
        Flux<Integer> just = Flux.just(1, 2, 3, 4);

        just.log()
                .subscribe(new Subscriber<>() {

                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("on Next" + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("on onComplete");
                    }
                });
    }


    private static void withSubscriberInterfaceBackPressure() {
        Flux<Integer> just = Flux.just(1, 2, 3, 4);

        just.log()
                .subscribe(new Subscriber<>() {
                    private Subscription s;
                    int onNext;

                    @Override
                    public void onSubscribe(Subscription s) {
                        this.s = s;
                        System.out.println("onSubscribe");
                        s.request(2);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("on Next" + integer);
                        onNext++;
                        if (onNext % 2 == 0) {
                            System.out.println("send 2 more");
                            s.request(2);
                        }

                    }

                    @Override
                    public void onError(Throwable t) {
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("on onComplete");
                    }
                });
    }


    private static void mapData(){

        Flux<Integer> just = Flux.just(1,2,3,4);
        just.log()
                .map(i->{
                    System.out.println("Mapp nethod called");
                    return i*2;
                })
                .subscribe(i->{
                    System.out.println("on next" + i);
                });

    }


    private static void infiniteHotStream(){
        ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
                    while(true) {
                        fluxSink.next(System.currentTimeMillis());
                    }
                })
                .publish();

        publish.subscribe(System.out::println);
        publish.subscribe(System.out::println);
        publish.connect();


    }

    private static void infiniteHotStreamWithThrottling(){
        ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
                    while(true) {
                        fluxSink.next(System.currentTimeMillis());
                    }
                })
                .sample(Duration.ofSeconds(2))
                .publish();

        publish.subscribe(System.out::println);
        publish.subscribe(System.out::println);
        publish.connect();


    }


    private static void concurrent(){
        Flux.just(1, 2, 3, 4)
                .log()
                .map(i -> i * 2)
                .subscribeOn(Schedulers.parallel())
                .subscribe(i-> System.out.println("h"));
    }



    private static Flux<Integer> getIntegerFlux(Flux<String> stringFlux){
       return stringFlux.map(s->Integer.parseInt(s));
    }

    public static void main(String[] args) {

        simple();
        //mapData();
        //infiniteHotStream();
        //infiniteHotStreamWithThrottling();
        //concurrent();

    }
}
