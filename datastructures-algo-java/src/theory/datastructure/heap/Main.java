package theory.datastructure.heap;

public class Main {


    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap();

        /*Adding elements to Heap*/
        System.out.println("Adding elements to Heap");
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(1);
        maxHeap.insert(11);
        maxHeap.insert(5);
        maxHeap.insert(9);
        maxHeap.insert(30);

        System.out.println("Printing Heap Values ");
        maxHeap.printHeap();

        System.out.println("Removing max value from heap:"+maxHeap.extractMax());
        System.out.println("Printing Heap Values After Removal");
        maxHeap.printHeap();
    }


}
