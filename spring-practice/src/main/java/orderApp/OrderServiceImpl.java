package orderApp;

public class OrderServiceImpl implements OrderService {

    private InventoryRepository inventoryRepository;
    private CustomerRepository customerRepository;

    public OrderServiceImpl(InventoryRepository inventoryRepository, CustomerRepository customerRepository){
        this.inventoryRepository = inventoryRepository;
        this.customerRepository = customerRepository;
    }

    public void processOrder() {
        System.out.println("processing Order");
    }
}
