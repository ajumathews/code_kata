package orderApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceConfig {

    @Bean
    public OrderService orderService(InventoryRepository inventoryRepository, CustomerRepository customerRepository){
        return  new OrderServiceImpl(inventoryRepository,customerRepository);
    }

    @Bean
    public InventoryRepository inventoryRepository(){
        return new InventoryRepository();
    }

    @Bean
    public CustomerRepository customerRepository(){
        return new CustomerRepository();
    }


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(OrderServiceConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        orderService.processOrder();
    }

}
