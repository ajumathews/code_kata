package theory.structural.composite;

import java.util.List;

public class NestedTodoItem implements Todo {

    private String title;
    private List<Todo> subTasks;

    public NestedTodoItem(String title, List<Todo> subTodoItems) {
        this.title = title;
        this.subTasks = subTodoItems;
    }

    @Override
    public String getHtml() {
        StringBuilder sb = new StringBuilder(title);
        for (Todo todo : subTasks) {
            sb.append("\n");
            sb.append(todo.getHtml());
        }
        return sb.toString();
    }
}
