package theory.challenges.linkedList.singlyLinkedList.twoPointer;

/*

Here the idea is to have two pointers

Traverse through the linkedlist till K element from the beginning.
Now check if the second has reached null. Then the node to be removed is the head.

Else. we traverse both the first and second. till the seconds next element is null.
Now we have reached the node to be removed.

Update the references


Eg:

1,2,3,4,5,null

Remove 2nd element from end.

1,2,3,4,5,null
F
S

Now iterate second till k times

1,2,3,4,5,null
F
    S

Check if second has reached null. Else traverse both first and second till the second reaches the last element.
1,2,3,4,5,null
    F
        S

 Update references of the node to be removed

 1,2,3,5,null

* */
public class Program {

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList first = head;
        LinkedList second = head;
        int counter = 1;

        //move the second till K
        while (counter <= k) {
            second = second.next;
            counter++;
        }

        //Check if second reached the end.
        if (second == null) {
            //removing head
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }

        //shift both first and second till the second reaches the last element
        while (second.next != null) {
            second = second.next;
            first = first.next;
        }

        first.next = first.next.next;

    }


    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
