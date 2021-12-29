package theory.synchronization.without;

public class Manager {

    private int currentTasks;
    private int totalTasksGiven;

    public Manager(int tasks) {
        this.currentTasks = tasks;
    }

    public int getCurrentTasks() {
        return currentTasks;
    }

    public void decrementCurrentTask() {
        this.currentTasks--;
    }

    public void addCurrentTask() {
        currentTasks++;
    }

    public int getTotalTasksGiven() {
        return totalTasksGiven;
    }

    public void incrementTotalTasksGiven(){
        totalTasksGiven++;
    }
}
