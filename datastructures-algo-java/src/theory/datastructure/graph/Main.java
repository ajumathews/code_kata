package theory.datastructure.graph;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();

        System.out.println("Adding Vertex");
        graph.addVertex("Tokyo");
        graph.addVertex("Dallas");
        graph.addVertex("Aspen");
        graph.addVertex("China");

        System.out.println("Adding Edge");
        graph.addEdge("Tokyo","Dallas");
        graph.addEdge("Tokyo","Aspen");
        graph.addEdge("Tokyo","China");
        graph.addEdge("Dallas","China");

        System.out.println("Removing Edge");
        graph.removeEdge("Tokyo","Dallas");

        System.out.println("Removing Vertex");
        graph.removeVertex("China");
        System.out.println("Removed Vertex");


    }

}
