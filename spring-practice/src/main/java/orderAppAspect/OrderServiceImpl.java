package orderAppAspect;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Loggable
    public int processOrder() {
        System.out.println("processing Order");
        return 1;
    }

    public String helloWorld(){
        return "hello world";
    }
}
