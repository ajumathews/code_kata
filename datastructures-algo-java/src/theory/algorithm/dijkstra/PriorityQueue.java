package theory.algorithm.dijkstra;

public class PriorityQueue {

    private HeapNode[] values;
    private int lastIndex;

    public PriorityQueue() {
        values = new HeapNode[10];
    }

    public void enqueue(String value, int priority) {
        HeapNode heapNode = new HeapNode(value,priority);
        values[lastIndex] = heapNode;
        bubbleUpValuetoCorrectIndex(lastIndex);
        lastIndex++;
    }

    private void bubbleUpValuetoCorrectIndex(int currentIndex) {
        if (currentIndex == 0) {
            return;
        }
        int parentIndex = (currentIndex - 1) / 2;
        if (values[parentIndex].getPriority() > values[currentIndex].getPriority()) {
            /*swap*/
            HeapNode temp = values[parentIndex];
            values[parentIndex] = values[currentIndex];
            values[currentIndex] = temp;
        }
        currentIndex = parentIndex;
        bubbleUpValuetoCorrectIndex(currentIndex);
    }


    public String dequeue() {
        HeapNode result = values[0];
        values[0] = values[lastIndex - 1];
        lastIndex--;
        tickleDownElementsToRightIndex(0);
        return result.getValue();
    }

    public int getSize(){
        return lastIndex;
    }

    private void tickleDownElementsToRightIndex(int currentIndex) {
        if (currentIndex == lastIndex - 1) {
            return;
        }
        int leftChildIndex = (2 * currentIndex) + 1;
        int rightChildIndex = (2 * currentIndex) + 2;
        int smallestChildIndex;
        if (leftChildIndex < lastIndex - 1) {
            if (rightChildIndex < lastIndex - 1) {
                if (values[leftChildIndex].getPriority() < values[rightChildIndex].getPriority()) {
                    smallestChildIndex = leftChildIndex;
                } else {
                    smallestChildIndex = rightChildIndex;
                }
            } else {
                smallestChildIndex = leftChildIndex;
            }
        } else {
            return;
        }

        if (values[currentIndex].getPriority() > values[smallestChildIndex].getPriority()) {
            /*swap*/
            HeapNode temp = values[currentIndex];
            values[currentIndex] = values[smallestChildIndex];
            values[smallestChildIndex] = temp;
        }

        currentIndex = smallestChildIndex;
        tickleDownElementsToRightIndex(currentIndex);
    }

    public void printPriorityQueue() {
        for (int i = 0; i < lastIndex; i++) {
            System.out.println(values[i]);
        }
    }


}


