package theory.structural.composite;

public class SingleTodo implements Todo{

    private String itemName;

    public SingleTodo(String todoItem) {
        this.itemName = todoItem;
    }

    @Override
    public String getHtml() {
        return itemName;
    }
}
