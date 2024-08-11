package leetcode;

import dijkstra.Route;

import java.util.*;

//https://leetcode.com/explore/featured/card/graph/622/single-source-shortest-path-algorithm/3863/
public class NetworkDelayTime {
    Map<Integer, List<Edge>> graph = new HashMap<>();

    public void populateRoute(int[][] routes) {
        for (int i = 0; i < routes.length; i++) {
            List<Edge> edges = graph.getOrDefault(routes[i][0], new ArrayList<>());
            edges.add(new Edge(routes[i][1], routes[i][2]));
            graph.put(routes[i][0], edges);
        }
    }

    public int networkDelayTime(int[][] times, int noOfVertices, int source) {
        populateRoute(times);
        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingInt(route -> route.getCost()));
        Route route = new Route(source, 0);
        pq.add(route);
        Map<Integer, Integer> visited = new HashMap<>();
        while (!pq.isEmpty()) {
            Route current = pq.poll();
            if (visited.containsKey(current.getName())) {
                continue;
            }
            visited.put(current.getName(), current.getCost());
            if (visited.size() == noOfVertices) {
                return visited.values().stream().max(Comparator.comparingInt(Integer::intValue)).get();
            }
            if (!graph.containsKey(current.getName())) {
                continue;
            }
            for (Edge neighbour : graph.get(current.getName())) {
                int newCost = current.getCost() + neighbour.weight;
                pq.offer(new Route(neighbour.destination, newCost));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        NetworkDelayTime networkDelay = new NetworkDelayTime();
        int mintime = networkDelay.networkDelayTime(times, n, k);
        System.out.println(mintime);
    }
}
