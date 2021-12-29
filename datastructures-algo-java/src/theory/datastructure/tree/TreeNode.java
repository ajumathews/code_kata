package theory.datastructure.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


class Main {




    /*
           1
        2  3  4
       7
    */

    public static void breadFirst(TreeNode input){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(input);

        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            System.out.println(node.getValue());
            if(node.getChildren() != null){
                queue.addAll(node.getChildren());
            }
        }
    }


    /*
           1
        2  3  4
       7
    */

    public static void depthFirstSearch(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getValue());
        List<TreeNode> children = node.getChildren();
        if (children != null) {
            for (TreeNode child : children) {
                depthFirstSearch(child);
            }
        }

    }


    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);


        one.addChild(two);
        two.setParent(one);

        one.addChild(three);
        three.setParent(one);

        one.addChild(four);
        four.setParent(one);

        two.addChild(seven);
        seven.setParent(two);

        TreeNode root = one;

        breadFirst(root);
    }
}


/*
        1
    2  3  4
   7
*/

public class TreeNode {

    private int value;
    private List<TreeNode> children;
    private TreeNode parent;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void addChild(TreeNode child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}


