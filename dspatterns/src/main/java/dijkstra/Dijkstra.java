package dijkstra;

import java.util.*;

public class Dijkstra<T> {


    public int shortestPathCost(int[][] edges, int source, int target) {
        Map<Integer, List<Edge>> graph = new Graph().initializeGraph(edges);
        Map<Integer, Integer> visited = new HashMap<>();
        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingInt(route -> route.cost));
        Route route = new Route(source, 0);
        pq.offer(route);
        while (!pq.isEmpty()) {
            Route curr = pq.poll();
            if (curr.name == target) {
                return curr.cost;
            }
            if (visited.containsKey(curr.name)) {
                continue;
            }
            if (!graph.containsKey(curr.name)) {
                continue;
            }
            for (Edge neighbour : graph.get(curr.name)) {
                Integer destination = neighbour.destination;
                Integer newCost = curr.cost + neighbour.cost;
                if (!visited.containsKey(destination) || neighbour.cost > newCost) {
                    pq.add(new Route(destination, newCost));
                }
            }
            visited.put(curr.name, curr.cost);
        }
        return -1;
    }


    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        int[][] input = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int cost = dijkstra.shortestPathCost(input, 0, 3);
        System.out.println(cost);
    }
}
