package dijkstra;

public class Route {
    Integer name;
    int cost;

    public Route(Integer destination, int cost) {
        this.name = destination;
        this.cost = cost;
    }

    public Integer getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
