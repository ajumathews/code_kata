package theory.datastructure.heap;

public class MaxHeap {

    private int[] values;
    private int lastIndex;

    public MaxHeap() {
        values = new int[10];
    }


    /*
             20
         10     5
       6   4  1

          ==> [20,10,5,6,4,1]
                0,1 ,2,3,4,5
     Add 30
              20
          10     5
        6   4  1  30

     Now check for 30s parent and if its larger 30 is in right place. If its smaller swap with its parent.
     now continue till root

              20
          10     30
        6   4  1   5

              30
          10     20
        6   4   1   5
    */

    public void insert(int i) {
        values[lastIndex] = i;
        bubbleUpValuetoCorrectIndex(lastIndex);
        lastIndex++;
    }

    private void bubbleUpValuetoCorrectIndex(int currentIndex) {
        if (currentIndex == 0) {
            return;
        }
        int parentIndex = (currentIndex - 1) / 2;
        if (values[parentIndex] < values[currentIndex]) {
            /*swap*/
            int temp = values[parentIndex];
            values[parentIndex] = values[currentIndex];
            values[currentIndex] = temp;
        }
        currentIndex = parentIndex;
        bubbleUpValuetoCorrectIndex(currentIndex);
    }



     /*
             30
          10     20
        6   4   1   5

          ==> [30,10,20,6,4,1,5]
                0,1 ,2, 3,4,5,6
     Remove 30

     Now swap the last element with the root

              5
          10     20
        6   4   1

       Now look for its children if its larger, its position is set. if its smaller it has to swap with the
       children . continue till you reach the last element

              20
          10     5
        6   4   1

    */

    public int extractMax() {
        int result = values[0];
        values[0] = values[lastIndex - 1];
        lastIndex--;
        tickleDownElementsToRightIndex(0);
        return result;
    }

    private void tickleDownElementsToRightIndex(int currentIndex) {
        if (currentIndex == lastIndex - 1) {
            return;
        }
        int leftChildIndex = (2 * currentIndex) + 1;
        int rightChildIndex = (2 * currentIndex) + 2;
        int largestChildIndex;
        if (leftChildIndex < lastIndex - 1) {
            if (rightChildIndex < lastIndex - 1) {
                if (values[leftChildIndex] > values[rightChildIndex]) {
                    largestChildIndex = leftChildIndex;
                } else {
                    largestChildIndex = rightChildIndex;
                }
            } else {
                largestChildIndex = leftChildIndex;
            }
        } else {
            return;
        }

        if (values[currentIndex] < values[largestChildIndex]) {
            /*swap*/
            int temp = values[currentIndex];
            values[currentIndex] = values[largestChildIndex];
            values[largestChildIndex] = temp;
        }

        currentIndex=largestChildIndex;
        tickleDownElementsToRightIndex(currentIndex);
    }

    public void printHeap() {
        for (int i = 0; i < lastIndex; i++) {
            System.out.println(values[i]);
        }
    }


}
