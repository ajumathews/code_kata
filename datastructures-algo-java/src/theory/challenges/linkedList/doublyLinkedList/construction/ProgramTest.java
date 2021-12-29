package theory.challenges.linkedList.doublyLinkedList.construction;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProgramTest {

    private void expectEmpty(DoublyLinkedList linkedList) {
        Assert.assertTrue(linkedList.head == null);
        Assert.assertTrue(linkedList.tail == null);
    }

    private void expectHeadTail(
            DoublyLinkedList linkedList, Node head, Node tail) {
        Assert.assertTrue(linkedList.head == head);
        Assert.assertTrue(linkedList.tail == tail);
    }

    private void expectSingleNode(DoublyLinkedList linkedList, Node node) {
        Assert.assertTrue(linkedList.head == node);
        Assert.assertTrue(linkedList.tail == node);
    }

    private List<Integer> getNodeValuesHeadToTail(DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        Node node = linkedList.head;
        while (node != null) {
            values.add(node.value);
            node = node.next;
        }
        return values;
    }

    private List<Integer> getNodeValuesTailToHead(DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        Node node = linkedList.tail;
        while (node != null) {
            values.add(node.value);
            node = node.prev;
        }
        return values;
    }

    private void removeNodes(DoublyLinkedList linkedList, List<Node> nodes) {
        for (Node node : nodes) {
            linkedList.remove(node);
        }
    }

    private boolean compare(List<Integer> array1, int[] array2) {
        if (array1.size() != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.size(); i++) {
            if (array1.get(i) != array2[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void TestCase1() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        Node node = new Node(1);

        linkedList.setHead(node);
        expectSingleNode(linkedList, node);
        linkedList.remove(node);
        expectEmpty(linkedList);
        linkedList.setTail(node);
        expectSingleNode(linkedList, node);
        linkedList.removeNodesWithValue(1);
        expectEmpty(linkedList);
        linkedList.insertAtPosition(1, node);
        expectSingleNode(linkedList, node);
    }

    @Test
    public void TestCase2() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        Node first = new Node(1);
        Node second = new Node(2);
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(first);
        nodes.add(second);

        linkedList.setHead(first);
        linkedList.setTail(second);
        expectHeadTail(linkedList, first, second);
        removeNodes(linkedList, nodes);
        expectEmpty(linkedList);
        linkedList.setHead(first);
        linkedList.insertAfter(first, second);
        expectHeadTail(linkedList, first, second);
        removeNodes(linkedList, nodes);
        linkedList.setHead(first);
        linkedList.insertBefore(first, second);
        expectHeadTail(linkedList, second, first);
        removeNodes(linkedList, nodes);
        linkedList.insertAtPosition(1, first);
        linkedList.insertAtPosition(2, second);
        expectHeadTail(linkedList, first, second);
        removeNodes(linkedList, nodes);
        linkedList.insertAtPosition(2, first);
        linkedList.insertAtPosition(1, second);
        expectHeadTail(linkedList, second, first);
    }

    @Test
    public void TestCase3() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        linkedList.setHead(first);
        Assert.assertTrue(linkedList.containsNodeWithValue(1) == true);
        linkedList.insertAfter(first, second);
        Assert.assertTrue(linkedList.containsNodeWithValue(2) == true);
        linkedList.insertAfter(second, third);
        Assert.assertTrue(linkedList.containsNodeWithValue(3) == true);
        linkedList.insertAfter(third, fourth);
        Assert.assertTrue(linkedList.containsNodeWithValue(4) == true);
        linkedList.removeNodesWithValue(3);
        Assert.assertTrue(linkedList.containsNodeWithValue(3) == false);
        linkedList.remove(first);
        Assert.assertTrue(linkedList.containsNodeWithValue(1) == false);
        linkedList.removeNodesWithValue(4);
        Assert.assertTrue(linkedList.containsNodeWithValue(4) == false);
        linkedList.remove(second);
        Assert.assertTrue(linkedList.containsNodeWithValue(2) == false);
    }

    @Test
    public void TestCase4() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(3);
        Node fifth = new Node(3);
        Node sixth = new Node(6);
        Node seventh = new Node(7);

        linkedList.setHead(first);
        linkedList.insertAfter(first, second);
        linkedList.insertAfter(second, third);
        linkedList.insertAfter(third, fourth);
        linkedList.insertAfter(fourth, fifth);
        linkedList.insertAfter(fifth, sixth);
        linkedList.insertAfter(sixth, seventh);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {1, 2, 3, 3, 3, 6, 7}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {7, 6, 3, 3, 3, 2, 1}));
        expectHeadTail(linkedList, first, seventh);
        linkedList.remove(second);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {1, 3, 3, 3, 6, 7}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {7, 6, 3, 3, 3, 1}));
        expectHeadTail(linkedList, first, seventh);
        linkedList.removeNodesWithValue(1);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {3, 3, 3, 6, 7}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {7, 6, 3, 3, 3}));
        expectHeadTail(linkedList, third, seventh);
        linkedList.removeNodesWithValue(3);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {6, 7}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {7, 6}));
        expectHeadTail(linkedList, sixth, seventh);
        linkedList.removeNodesWithValue(7);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {6}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6}));
        expectHeadTail(linkedList, sixth, sixth);
    }

    @Test
    public void TestCase5() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);

        linkedList.setHead(first);
        linkedList.insertAfter(first, second);
        linkedList.insertAfter(second, third);
        linkedList.insertAfter(third, fourth);
        linkedList.insertAfter(fourth, fifth);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {1, 2, 3, 4, 5}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {5, 4, 3, 2, 1}));
        expectHeadTail(linkedList, first, fifth);
        linkedList.insertAfter(third, fifth);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {1, 2, 3, 5, 4}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {4, 5, 3, 2, 1}));
        expectHeadTail(linkedList, first, fourth);
        linkedList.insertAfter(third, first);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {2, 3, 1, 5, 4}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {4, 5, 1, 3, 2}));
        expectHeadTail(linkedList, second, fourth);
        linkedList.insertAfter(fifth, second);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {3, 1, 5, 2, 4}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {4, 2, 5, 1, 3}));
        expectHeadTail(linkedList, third, fourth);
        linkedList.insertAfter(second, first);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {3, 5, 2, 1, 4}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {4, 1, 2, 5, 3}));
        expectHeadTail(linkedList, third, fourth);
        linkedList.insertAfter(fourth, sixth);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {3, 5, 2, 1, 4, 6}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 4, 1, 2, 5, 3}));
        expectHeadTail(linkedList, third, sixth);
        linkedList.insertAfter(second, seventh);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {3, 5, 2, 7, 1, 4, 6}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 4, 1, 7, 2, 5, 3}));
        expectHeadTail(linkedList, third, sixth);
    }

    @Test
    public void TestCase6() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);

        linkedList.setHead(first);
        linkedList.insertBefore(first, second);
        linkedList.insertBefore(second, third);
        linkedList.insertBefore(third, fourth);
        linkedList.insertBefore(fourth, fifth);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {5, 4, 3, 2, 1}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {1, 2, 3, 4, 5}));
        expectHeadTail(linkedList, fifth, first);
        linkedList.insertBefore(third, first);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {5, 4, 1, 3, 2}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {2, 3, 1, 4, 5}));
        expectHeadTail(linkedList, fifth, second);
        linkedList.insertBefore(fifth, second);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {2, 5, 4, 1, 3}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 1, 4, 5, 2}));
        expectHeadTail(linkedList, second, third);
        linkedList.insertBefore(fifth, fourth);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {2, 4, 5, 1, 3}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 1, 5, 4, 2}));
        expectHeadTail(linkedList, second, third);
        linkedList.insertBefore(second, sixth);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {6, 2, 4, 5, 1, 3}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 1, 5, 4, 2, 6}));
        expectHeadTail(linkedList, sixth, third);
        linkedList.insertBefore(first, seventh);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {6, 2, 4, 5, 7, 1, 3}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 1, 7, 5, 4, 2, 6}));
        expectHeadTail(linkedList, sixth, third);
    }

    @Test
    public void TestCase7() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);

        linkedList.setHead(first);
        linkedList.insertAtPosition(1, second);
        linkedList.insertAtPosition(1, third);
        linkedList.insertAtPosition(1, fourth);
        linkedList.insertAtPosition(1, fifth);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {5, 4, 3, 2, 1}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {1, 2, 3, 4, 5}));
        expectHeadTail(linkedList, fifth, first);
        linkedList.insertAtPosition(2, first);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {5, 1, 4, 3, 2}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {2, 3, 4, 1, 5}));
        expectHeadTail(linkedList, fifth, second);
        linkedList.insertAtPosition(1, second);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {2, 5, 1, 4, 3}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 4, 1, 5, 2}));
        expectHeadTail(linkedList, second, third);
        linkedList.insertAtPosition(2, fourth);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {2, 4, 5, 1, 3}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 1, 5, 4, 2}));
        expectHeadTail(linkedList, second, third);
        linkedList.insertAtPosition(1, sixth);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {6, 2, 4, 5, 1, 3}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 1, 5, 4, 2, 6}));
        expectHeadTail(linkedList, sixth, third);
        linkedList.insertAtPosition(5, seventh);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {6, 2, 4, 5, 7, 1, 3}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 1, 7, 5, 4, 2, 6}));
        expectHeadTail(linkedList, sixth, third);
        linkedList.insertAtPosition(8, fourth);
        Assert.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[] {6, 2, 5, 7, 1, 3, 4}));
        Assert.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[] {4, 3, 1, 7, 5, 2, 6}));
        expectHeadTail(linkedList, sixth, fourth);
    }
}
