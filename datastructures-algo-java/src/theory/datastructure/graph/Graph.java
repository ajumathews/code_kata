package theory.datastructure.graph;

import java.util.*;

public class Graph {

    private Map<String, Vertex> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap();
    }

    public void addVertex(String vertexName) {
        Vertex vertex = new Vertex(vertexName);
        adjacencyMap.put(vertexName, vertex);
    }

    public void addEdge(String source, String destination) {
        Vertex sourceVertex = adjacencyMap.get(source);
        Vertex destinationVertex = adjacencyMap.get(destination);

        sourceVertex.getEdges().add(destinationVertex);
        destinationVertex.getEdges().add(sourceVertex);
    }

    public void removeEdge(String source, String destination) {
        Vertex sourceVertex = adjacencyMap.get(source);
        Vertex destinationVertex = adjacencyMap.get(destination);

        sourceVertex.getEdges().remove(destinationVertex);
        destinationVertex.getEdges().remove(sourceVertex);
    }

    public void removeVertex(String vertexNameToBeRemoved) {
        Vertex vertexToBeRemoved = adjacencyMap.get(vertexNameToBeRemoved);

        /*Remove the vertex from all the edges in all the vertex*/
        for (String vertexName : adjacencyMap.keySet()) {
            Vertex vertex = adjacencyMap.get(vertexName);
            vertex.getEdges().remove(vertexToBeRemoved);
        }

        /*Remove the vertex from adjacency list*/
        adjacencyMap.remove(vertexNameToBeRemoved);
    }


    /*A,B,D,E,C,F*/
    public void depthFirstSearchRecursive(String startVertex) {
         Set<String> visitedVertex = new HashSet<>();
        depthFirstSearchRecursiveHelper(visitedVertex, startVertex);
    }


    private void depthFirstSearchRecursiveHelper(Set<String> visitedVertex, String vertexName) {
        Vertex vertex = adjacencyMap.get(vertexName);
        if (vertex == null) {
            return;
        }
        System.out.println(vertex.getName());
        visitedVertex.add(vertexName);
        List<Vertex> neighbours = vertex.getEdges();
        for (Vertex neighbour : neighbours) {
            if (!visitedVertex.contains(neighbour.getName())) {
                depthFirstSearchRecursiveHelper(visitedVertex, neighbour.getName());
            }
        }
    }

    /*A, C, E, F, D, B*/
    public void depthFirstSearchIterative(String startVertex) {
        Stack<Vertex> stack = new Stack<>();
        Set<String> visitedVertex = new HashSet<>();
        stack.add(adjacencyMap.get(startVertex));
        visitedVertex.add(startVertex);

        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            System.out.println(vertex.getName());
            for (Vertex neighbour : vertex.getEdges()) {
                if (!visitedVertex.contains(neighbour.getName())) {
                    stack.push(neighbour);
                    visitedVertex.add(neighbour.getName());
                }
            }
        }
    }

    /*A, B, C, D, E, F*/
    public void breadthFirstSearch(String startVertex){
        Set<String> visitedVertex = new HashSet<>();
        Queue<Vertex> queue = new ArrayDeque<>();

        queue.add(adjacencyMap.get(startVertex));
        visitedVertex.add(startVertex);

        while(!queue.isEmpty()){
            Vertex currentVertex=queue.remove();
            System.out.println(currentVertex.getName());
            for(Vertex neighbour: currentVertex.getEdges()){
                if(!visitedVertex.contains(neighbour.getName())){
                    queue.add(neighbour);
                    visitedVertex.add(neighbour.getName());
                }
            }

        }

    }

}
