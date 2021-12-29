package helloworld;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:/application.properties")
public class HelloWorldFromPropertyConfigScope {

    @Value("${greetings.text}")
    private String value;

    @Bean
    //@Scope("prototype")
    public Worker worker(){
        System.out.println("Instance Created");
        return new Worker(value);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldFromPropertyConfigScope.class);
        Worker worker = context.getBean(Worker.class);
        worker.execute();

        Worker worker2 = context.getBean(Worker.class);
        worker2.execute();

        }


    public class Worker{
        private String greeting;

        public Worker(String greeting) {
            this.greeting = greeting;
        }

        public void execute(){
            System.out.println("Hello "+greeting);
        }
    }


}
