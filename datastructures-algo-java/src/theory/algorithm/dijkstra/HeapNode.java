package theory.algorithm.dijkstra;

public class HeapNode {

    private String value;
    private int priority;

    public HeapNode(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "HeapNode{" +
                "value='" + value + '\'' +
                ", priority=" + priority +
                '}';
    }
}
