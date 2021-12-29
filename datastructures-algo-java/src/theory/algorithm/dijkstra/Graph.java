package theory.algorithm.dijkstra;

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

    public void addEdge(String source, String destination, int weight) {
        Vertex sourceVertex = adjacencyMap.get(source);
        Vertex destinationVertex = adjacencyMap.get(destination);
        sourceVertex.getEdges().add(new Edge(destinationVertex, weight));
        destinationVertex.getEdges().add(new Edge(sourceVertex, weight));
    }

    public void findShortestPath(String startVertexName, String endVertexName){
        PriorityQueue priorityQueue = new PriorityQueue();
        Map<String, String> previousMap= new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();
        Vertex smallest;

        /*Initialize*/
        for(String vertexName: adjacencyMap.keySet()){
            /*Build Initial Distances*/
            if(vertexName.equals(startVertexName)){
                distances.put(vertexName,0);
                priorityQueue.enqueue(vertexName,0);
            }else{
                distances.put(vertexName,Integer.MAX_VALUE);
                priorityQueue.enqueue(vertexName,Integer.MAX_VALUE);
            }

            /*Build Previous Map*/
            previousMap.put(vertexName,null);
        }

        while(priorityQueue.getSize()>0){
            smallest=adjacencyMap.get(priorityQueue.dequeue());
            if(smallest.equals(endVertexName)){
                /*done*/
            }
            for(Edge edge:smallest.getEdges()){
                Vertex neighbour = edge.getDestination();
                previousMap.put(neighbour.getName(),smallest.getName());
                distances.put(neighbour.getName(),edge.getWeight());
                priorityQueue.enqueue(neighbour.getName(),edge.getWeight());
            }
        }



    }


}
