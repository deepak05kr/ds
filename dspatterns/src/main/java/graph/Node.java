package graph;

public class Node<T> {
    Vertex<T> vertex;
    int weight;

    public Node(Vertex<T> vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
