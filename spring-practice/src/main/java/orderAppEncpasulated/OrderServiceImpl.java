package orderAppEncpasulated;

public class OrderServiceImpl implements OrderService {

    private InventoryRepository inventoryRepository;
    private CustomerRepository customerRepository;

    public OrderServiceImpl(InventoryRepository inventoryRepository, CustomerRepository customerRepository){
        this.inventoryRepository = inventoryRepository;
        this.customerRepository = customerRepository;
    }

    public void processOrder() {
        System.out.println(inventoryRepository);
        System.out.println(customerRepository);
        System.out.println("processing Order");
    }
}
