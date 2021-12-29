package theory.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private List<Vertex> edges;

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

    public List<Vertex> getEdges() {
        return edges;
    }

    public void setEdges(List<Vertex> edges) {
        this.edges = edges;
    }

}
