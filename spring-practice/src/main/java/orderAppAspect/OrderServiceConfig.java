package orderAppAspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"orderAppAspect"})
@EnableAspectJAutoProxy
public class OrderServiceConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(OrderServiceConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        orderService.processOrder();
        orderService.helloWorld();
    }

}
