package theory.datastructure.heap;

public class MainPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();

        priorityQueue.enqueue("common cold",5);
        priorityQueue.enqueue("heart attack",1);
        priorityQueue.enqueue("fever",3);
        priorityQueue.enqueue("high Fever",2);
        priorityQueue.enqueue("Accident case",4);

        priorityQueue.printPriorityQueue();


    }

}
