package theory.algorithm.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private List<Edge> edges;

    public Vertex(String name) {
        this.name = name;
        this.edges = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
