package finalPractise;

/*

Here we have made sure the internals of Customer - only the name cant be changed once created.
This make sure we have our code doest modify the properties marked as final.

here numberOfPurchase is not marked as final since that changes.

* */
public class FinalCustomer {

    private final String name;
    private int numberOfPurchase;

    FinalCustomer(String name){
        this.name =name;
    }

    public static void main(String[] args) {
        final FinalCustomer customer = new FinalCustomer("aju");

        incrementNoOfPurchases(customer);
        buggyCode(customer);

        System.out.println(customer.name);

        //This cant be done
        //customer = new Customer();
    }

    static void buggyCode(FinalCustomer customer){
        //This cant be done
        //customer.name="Buggy Name";
    }

    static void incrementNoOfPurchases(FinalCustomer customer){
        customer.numberOfPurchase++;
    }
}
