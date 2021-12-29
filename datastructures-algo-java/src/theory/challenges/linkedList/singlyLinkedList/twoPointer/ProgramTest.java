package theory.challenges.linkedList.singlyLinkedList.twoPointer;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;


public class ProgramTest {
    @Test
    public void TestCase1() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        Program.removeKthNodeFromEnd(test, 1);
        Assert.assertTrue(compare(test.getNodesInArray(), expected));
    }

    @Test
    public void TestCase2() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        Program.removeKthNodeFromEnd(test, 2);
        Assert.assertTrue(compare(test.getNodesInArray(), expected));
    }

    @Test
    public void TestCase3() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 8, 9};
        Program.removeKthNodeFromEnd(test, 3);
        Assert.assertTrue(compare(test.getNodesInArray(), expected));
    }

    @Test
    public void TestCase4() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        Program.removeKthNodeFromEnd(test, 4);
        Assert.assertTrue(compare(test.getNodesInArray(), expected));
    }

    @Test
    public void TestCase5() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {0, 1, 2, 3, 4, 6, 7, 8, 9};
        Program.removeKthNodeFromEnd(test, 5);
        Assert.assertTrue(compare(test.getNodesInArray(), expected));
    }

    @Test
    public void TestCase6() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {0, 1, 2, 3, 5, 6, 7, 8, 9};
        Program.removeKthNodeFromEnd(test, 6);
        Assert.assertTrue(compare(test.getNodesInArray(), expected));
    }

    @Test
    public void TestCase7() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {0, 1, 2, 4, 5, 6, 7, 8, 9};
        Program.removeKthNodeFromEnd(test, 7);
        Assert.assertTrue(compare(test.getNodesInArray(), expected));
    }

    @Test
    public void TestCase8() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {0, 1, 3, 4, 5, 6, 7, 8, 9};
        Program.removeKthNodeFromEnd(test, 8);
        Assert.assertTrue(compare(test.getNodesInArray(), expected));
    }

    @Test
    public void TestCase9() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {0, 2, 3, 4, 5, 6, 7, 8, 9};
        Program.removeKthNodeFromEnd(test, 9);
        Assert.assertTrue(compare(test.getNodesInArray(), expected));
    }

    @Test
    public void TestCase10() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Program.removeKthNodeFromEnd(test, 10);
        for(int i: test.getNodesInArray()){
            System.out.println(i);
        }
        Assert.assertTrue(compare(test.getNodesInArray(), expected));
    }

    public boolean compare(List<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    class TestLinkedList extends Program.LinkedList {

        public TestLinkedList(int value) {
            super(value);
        }

        public void addMany(int[] values) {
            Program.LinkedList current = this;
            while (current.next != null) {
                current = current.next;
            }
            for (int value : values) {
                current.next = new Program.LinkedList(value);
                current = current.next;
            }
        }

        public List<Integer> getNodesInArray() {
            List<Integer> nodes = new ArrayList<Integer>();
            Program.LinkedList current = this;
            while (current != null) {
                nodes.add(current.value);
                current = current.next;
            }
            return nodes;
        }
    }
}

