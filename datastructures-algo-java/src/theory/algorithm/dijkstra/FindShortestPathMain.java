package theory.algorithm.dijkstra;

public class FindShortestPathMain {


    public static void main(String[] args) {
        Graph graph= new Graph();

        System.out.println("Adding Vertex");
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        System.out.println("Adding Edges");
        graph.addEdge("A","B",4);
        graph.addEdge("A","C",2);
        graph.addEdge("C","D",2);
        graph.addEdge("C","F",4);
        graph.addEdge("B","E",3);
        graph.addEdge("D","E",3);
        graph.addEdge("D","F",1);
        graph.addEdge("F","E",1);

        System.out.println("Finding Shortest Path between Vertexes");
        graph.findShortestPath("A","E");
    }

}
