package feign;

public interface PaymentService extends Service {

    @RequestLine("GET /payments/balance")
    String getBalance();
}
