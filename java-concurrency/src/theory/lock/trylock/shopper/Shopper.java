package theory.lock.trylock.shopper;

public class Shopper {

    private String name;
    private int itemsToAdd;

    public Shopper(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemsToAdd() {
        return itemsToAdd;
    }

    public void setItemsToAdd(int itemsToAdd) {
        this.itemsToAdd = itemsToAdd;
    }
}
