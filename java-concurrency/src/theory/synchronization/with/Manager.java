package theory.synchronization.with;

public class Manager {

    private int currentTasks;
    private int totalTasksGiven;

    public Manager(int tasks) {
        this.currentTasks = tasks;
    }

    public int getCurrentTasks() {
        return currentTasks;
    }

    public void decrementCurrentTasks() {
        this.currentTasks--;
    }

    public void addCurrentTask() {
        currentTasks++;
    }

    public void incrementTotalTask() {
        totalTasksGiven++;
    }

    public int getTotalTasksGiven() {
        return totalTasksGiven;
    }
}
