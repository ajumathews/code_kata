package finalPractise;

/*

Here even though we made the customer as final the only thing we can do is that the referenc of customer
variable assigned cant be changed.

The internals of customer object can be modified
* */
public class Customer {

    private String name;
    private int numberOfPurchase;


    public static void main(String[] args) {
        final Customer customer = new Customer();
        customer.name="Aju";

        incrementNoOfPurchases(customer);
        buggyCode(customer);

        System.out.println(customer.name);

        //This cant be done
        //customer = new Customer();
    }

    static void buggyCode(Customer customer){
        customer.name="Buggy Name";
    }

    static void incrementNoOfPurchases(Customer customer){
        customer.numberOfPurchase++;
    }
}
