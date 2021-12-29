package theory.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Todo java = new SingleTodo("Learn Java");
        System.out.println(java.getHtml());


        List<Todo> jobHuntSubTasks = new ArrayList<>();
        jobHuntSubTasks.add(new SingleTodo("Learn System Design"));
        jobHuntSubTasks.add(new SingleTodo("Practise DS"));
        Todo jobHunt = new NestedTodoItem("jobHunt", jobHuntSubTasks);
        System.out.println(jobHunt.getHtml());

    }
}
