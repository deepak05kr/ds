package graph;

import java.util.Objects;

public class Edge<T> {
    Vertex<T> vertex1;
    Vertex<T> vertex2;
    boolean isDirected;
    int weight;

    public Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.isDirected = isDirected;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        Edge<?> edge = (Edge<?>) o;
        return isDirected == edge.isDirected && weight == edge.weight && Objects.equals(vertex1, edge.vertex1) && Objects.equals(vertex2, edge.vertex2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex1, vertex2, isDirected, weight);
    }

    public boolean isDirected() {
        return isDirected;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex<T> getVertex2() {
        return vertex2;
    }

    public Vertex<T> getVertex1() {
        return vertex1;
    }
}
