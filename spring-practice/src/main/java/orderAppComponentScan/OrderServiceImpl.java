package orderAppComponentScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class OrderServiceImpl implements OrderService {

    private final InventoryRepository inventoryRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrderServiceImpl(InventoryRepository inventoryRepository, CustomerRepository customerRepository){
        this.inventoryRepository = inventoryRepository;
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    public void init(){
        System.out.println("App Started");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("App End");
    }


    public void processOrder() {
        System.out.println("processing Order");
    }
}
