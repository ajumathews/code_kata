package theory.datastructure.graph;

public class GraphTraversalMain {


    public static void main(String[] args) {
        Graph graph= new Graph();

        System.out.println("Adding Vertex");
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        System.out.println("Adding Edge");
        graph.addEdge("A","B");
        graph.addEdge("A","C");
        graph.addEdge("B","D");
        graph.addEdge("D","E");
        graph.addEdge("D","F");
        graph.addEdge("E","C");
        graph.addEdge("E","F");

        System.out.println("Depth First Search Recursive");
        graph.depthFirstSearchRecursive("A");

        System.out.println("Depth First Search Iterative");
        graph.depthFirstSearchIterative("A");

        System.out.println("Breadth First Search Iterative");
        graph.breadthFirstSearch("A");

    }

}
