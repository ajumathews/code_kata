package orderAppEncpasulated;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderDataConfig {

    @Bean
    public InventoryRepository inventoryRepository(){
        return new InventoryRepository();
    }

    @Bean
    public CustomerRepository customerRepository(){
        return new CustomerRepository();
    }

}
