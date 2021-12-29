package helloworld;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:/application-${spring.profiles.active}.properties")
public class HelloWorldFromPropertyConfigProfilesDynamic {

    @Value("${greetings.text}")
    private String value;

    @Value("${greetings.preamble}")
    private String preamble;

    @Bean
    public Worker worker(){
        return new Worker(preamble,value);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldFromPropertyConfigProfilesDynamic.class);
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
