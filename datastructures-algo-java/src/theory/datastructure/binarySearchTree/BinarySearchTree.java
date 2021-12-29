package theory.datastructure.binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }


        /*
    Tree:
                 10
             7       20
          1        11

    Pick all the elements in on level, then go to the level down and so on the right elements
    Output - Breadth first- 10,7,20,1,11
    * */

    public void traverseTreebreadthFirst() {
        LinkedList<TreeNode> queue = new LinkedList();
        List<Integer> visited = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            visited.add(node.getData());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }

        }

        for (Integer i : visited) {
            System.out.println(i);
        }

    }


    /*
 Tree:
            10
        7       20
     1        11

 Pick all the left elements first , then the right elements, then the node element
 Output - Depth first Pre Order- 10,7,1,20,11
 * */
    public void traverseTreeDepthFirstPreOrder() {
        if (root != null) {
            root.traverseTreeDepthFirstPreOrder();
        }
    }


    /*
Tree:
           10
       7       20
    1        11

Pick all the left elements first , then the right elements, then the node element
Output - Depth first Pre Order- 1,7,,11,20,10
* */
    public void traverseTreeDepthFirstPostOrder() {
        if (root != null) {
            root.traverseTreeDepthFirstPostOrder();
        }
    }



    /*
Tree:
             10
         7       20
      1        11

Pick all the left elements first , then the current node and then the right elements
Output - Depth first Pre Order- 1,7,10,11,20
* */
    public void traverseTreeDepthFirstInOrder() {
        if (root != null) {
            root.traverseTreeDepthFirstInOrder();
        }
    }


    public int getValue(int value) {
        if (root != null) {
            return root.getValue(value);
        }
        return -1;
    }

    public int getMin() {
        if (root != null) {
            return root.getMin();
        }
        return -1;
    }

    public int getMax() {
        if (root != null) {
            return root.getMax();
        }
        return -1;
    }

}
