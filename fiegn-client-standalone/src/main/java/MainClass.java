import feign.DrugDbRetrieveService;
import servicediscovery.ServiceDiscoveryManager;

public class MainClass {

    public static void main(String[] args) {
        ServiceDiscoveryManager manager = new ServiceDiscoveryManager("feign.properties");
 /*       PaymentService paymentService = manager.getClient(PaymentService.class,"PAYMENT-SERVICE");
        System.out.println(paymentService.getBalance());*/

        DrugDbRetrieveService drugDbRetrieveService = (DrugDbRetrieveService) manager.getClient(DrugDbRetrieveService.class, "cortellisdrugdbretrieveservice");
        System.out.println(drugDbRetrieveService.checkForecastChartAvailability("company", "12135"));

    }
}
