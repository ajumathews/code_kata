package theory.lock.trylock.hotel;

import java.util.ArrayList;
import java.util.List;

public class Cook {

    private String name;
    private List<String> itemsToCook;

    public Cook(String name) {
        itemsToCook = new ArrayList<>();
        this.name = name;
    }

    public void addNewItems(List<String> newItemsFromWaiter) {
        itemsToCook.addAll(newItemsFromWaiter);
    }

    public List<String> getItemsToCook() {
        return new ArrayList<>(itemsToCook);
    }

    public int getItemSize() {
        return itemsToCook.size();
    }

    public String getName() {
        return name;
    }
}
