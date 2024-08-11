package dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    Map<Integer, List<Edge>> graph = new HashMap<>();

    public void addPath(Integer source, Integer destination, int cost) {
        List<Edge> edges = graph.getOrDefault(source, new ArrayList<>());
        edges.add(new Edge(destination, cost));
        graph.put(source, edges);
    }

    public <T> Map<Integer, List<Edge>> initializeGraph(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            addPath((int) edges[i][0], edges[i][1], (int) edges[i][2]);
        }
        return graph;
    }
}
