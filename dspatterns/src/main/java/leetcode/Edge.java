package leetcode;

public class Edge {
    Integer destination;
    int weight;

    public Edge(Integer destination, Integer weight) {
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "destination=" + destination +
                ", weight=" + weight +
                '}';
    }
}
