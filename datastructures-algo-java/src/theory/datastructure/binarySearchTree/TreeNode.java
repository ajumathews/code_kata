package theory.datastructure.binarySearchTree;

public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (data == value) {
            return;
        }

        if (value < data) {
            if (left == null) {
                left = new TreeNode(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new TreeNode(value);
            } else {
                right.insert(value);
            }
        }
    }

    public void traverseTreeDepthFirstInOrder() {
        if (left != null) {
            left.traverseTreeDepthFirstInOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.traverseTreeDepthFirstInOrder();
        }
    }

    public void traverseTreeDepthFirstPreOrder() {
        System.out.println(data);
        if (left != null) {
            left.traverseTreeDepthFirstPreOrder();        }

        if (right != null) {
            right.traverseTreeDepthFirstPreOrder();
        }
    }

    public void traverseTreeDepthFirstPostOrder() {
        if (left != null) {
            left.traverseTreeDepthFirstPostOrder();        }

        if (right != null) {
            right.traverseTreeDepthFirstPostOrder();
        }
        System.out.println(data);
    }

    public int getValue(int value) {
        if (data == value) {
            return value;
        }
        if (value < data) {
            if (left != null) {
                return left.getValue(value);
            }
        } else {

            if (right != null) {
                return right.getValue(value);
            }
        }
        return -1;
    }

    public int getMin() {
        if (left == null) {
            return data;
        } else {
            return left.getMin();
        }
    }


    public int getMax() {
        if (right == null) {
            return data;
        } else {
            return right.getMax();
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
