package theory.synchronization.with;

public class Worker {

    private int tasksDone;

    public int getTasksDone() {
        return tasksDone;
    }

    public void incrementTasksDone() {
        tasksDone++;
    }

}
