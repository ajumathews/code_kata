package helloworld;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:/application.properties")
public class HelloWorldFromPropertyConfigProfiles {

    @Value("${greetings.text}")
    private String value;

    @Bean
    @Profile("dev")
    public Worker workerDev(){
        return new Worker("Dev",value);
    }

    @Bean
    @Profile("prod")
    public Worker workerProd(){
        return new Worker("Prod",value);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldFromPropertyConfigProfiles.class);
        Worker worker = context.getBean(Worker.class);
        worker.execute();

        }


    public class Worker{
        private String preamble;
        private String greeting;

        public Worker(String preamble, String greeting) {
            this.preamble = preamble;
            this.greeting = greeting;
        }

        public void execute(){
            System.out.println(preamble+" "+greeting);
        }
    }


}
