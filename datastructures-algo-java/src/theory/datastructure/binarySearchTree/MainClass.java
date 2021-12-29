package theory.datastructure.binarySearchTree;

public class MainClass {


    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree();

        /*insert*/
        searchTree.insert(10);
        searchTree.insert(20);
        searchTree.insert(7);
        searchTree.insert(11);
        searchTree.insert(1);

        /*Breadth First Search*/
        System.out.println("Breadth First Search");
        searchTree.traverseTreebreadthFirst();

        /*Depth First Search Pre Order*/
        System.out.println("Depth First Search Pre Order");
        searchTree.traverseTreeDepthFirstPreOrder();

        /*Depth First Search Post Order*/
        System.out.println("Depth First Search post Order");
        searchTree.traverseTreeDepthFirstPostOrder();


        /*Depth First Search In Order*/
        System.out.println("Depth First Search In Order");
        searchTree.traverseTreeDepthFirstInOrder();

        /*Get operation*/
        System.out.println("Get :"+searchTree.getValue(1));

        /*Min and Max*/
        System.out.println("Max :"+searchTree.getMax());
        System.out.println("Min: "+searchTree.getMin());


    }
}
