package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    T data;
    List<Vertex<T>> adjacentVertices;
    List<Edge<T>> edgeList;

    public Vertex(T data) {
        this.data = data;
        this.adjacentVertices = new ArrayList<>();
        this.edgeList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                '}';
    }
}
