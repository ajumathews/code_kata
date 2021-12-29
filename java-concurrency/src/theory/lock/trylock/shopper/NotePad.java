package theory.lock.trylock.shopper;

/*
Here We have two shoppers who are adding items to notepad and also browsing items to buy.

* */
public class NotePad {

    private int itemsInNotePad;

    public int getItemsInNotePad() {
        return itemsInNotePad;
    }

    public void setItemsInNotePad(int itemsInNotePad) {
        this.itemsInNotePad = itemsInNotePad;
    }
}
