package theory.lock.trylock.hotel;

import java.util.ArrayList;
import java.util.List;

public class Waiter {

    private String name;
    private List<String> orders;

    public Waiter(String name) {
        orders = new ArrayList<>();
        this.name = name;

    }

    public void addItem(String item) {
        orders.add(item);

    }

    public void emptyOrders() {
        orders = new ArrayList<>();
    }

    public List<String> getOrders() {
        return new ArrayList<>(orders);
    }

    public int getOrderSize() {
        return orders.size();
    }

    public String getName() {
        return name;
    }
}
