package dijkstra;

public class Edge {
    Integer destination;
    int cost;

    public Edge(Integer data, int cost) {
        this.destination = data;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "data=" + destination +
                ", cost=" + cost +
                '}';
    }
}
