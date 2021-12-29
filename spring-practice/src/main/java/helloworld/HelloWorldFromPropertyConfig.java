package helloworld;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application.properties")
public class HelloWorldFromPropertyConfig {

    @Value("${greetings.text}")
    private String value;

    @Bean
    public Worker worker(){
        return new Worker(value);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldFromPropertyConfig.class);
        Worker worker = context.getBean(Worker.class);
        worker.execute();

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
