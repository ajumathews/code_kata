package theory.datastructure.binaryTree;




/*
            1
          2    3
        9   4
* */

import java.util.ArrayDeque;
import java.util.Queue;

class MainClass{

    public static void breadthFirst(Node node){

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node element = queue.remove();
            System.out.println(element.getValue());
            if(element.getLeft() != null){
                queue.add(element.getLeft());
            }

            if(element.getRight() != null){
                queue.add(element.getRight());
            }

        }

    }

    public static void depthFirst(Node node){
        if(node == null){
            return;
        }

        System.out.println(node.getValue());
        depthFirst(node.getLeft());
        depthFirst(node.getRight());
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node nine = new Node(9);

        Node root = one;
        one.setLeft(two);
        one.setRight(three);

        two.setLeft(nine);
        two.setRight(four);
        breadthFirst(root);

    }
}


public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
