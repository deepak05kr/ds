package graph;

import java.util.*;

public class StronglyConnectedComponents {
    public List<Set<Vertex<Integer>>> getStronglyConnectedComponents(Graph<Integer> graph) {
        Deque<Vertex<Integer>> stack = new ArrayDeque<>();
        Set<Vertex<Integer>> visited = new HashSet<>();
        for (Vertex vertex : graph.getAllVertices()) {
            DFSUtil(vertex, stack, visited);
        }
        visited.clear();
        Graph<Integer> reversedGraph = reveredGraph(graph);

        List<Set<Vertex<Integer>>> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            Vertex<Integer> curr = reversedGraph.getVertex(stack.pop().data);
            if (visited.contains(curr)) {
                continue;
            }
            Set<Vertex<Integer>> connectedComponent = new HashSet<>();
            DFSUtilRevered(curr, connectedComponent, visited);
            result.add(connectedComponent);
        }
        return result;
    }

    private void DFSUtilRevered(Vertex<Integer> curr, Set<Vertex<Integer>> connectedComponen, Set<Vertex<Integer>> visited) {

        visited.add(curr);
        connectedComponen.add(curr);
        for (Vertex<Integer> vertex : curr.adjacentVertices) {
            if (visited.contains(vertex)) {
                continue;
            }
            DFSUtilRevered(vertex, connectedComponen, visited);
        }

    }


    private Graph<Integer> reveredGraph(Graph<Integer> graph) {
        Graph<Integer> reversedGraph = new Graph<>(true);
        for (Edge<Integer> edge : graph.getAllEdges()) {
            reversedGraph.addEdge(edge.getVertex2().data, edge.getVertex1().data, 0);
        }
        return reversedGraph;
    }

    private void DFSUtil(Vertex<Integer> vertex, Deque<Vertex<Integer>> stack, Set<Vertex<Integer>> visited) {
        if (visited.contains(vertex)) {
            return;
        }
        visited.add(vertex);
        for (Vertex<Integer> v : vertex.adjacentVertices) {
            DFSUtil(v, stack, visited);
        }
        stack.offerFirst(vertex);
    }

    public static void main(String args[]) {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(0, 1, 0);
        graph.addEdge(1, 2, 0);
        graph.addEdge(2, 0, 0);
        graph.addEdge(1, 3, 0);
        graph.addEdge(3, 4, 0);
        graph.addEdge(4, 5, 0);
        graph.addEdge(5, 3, 0);
        graph.addEdge(5, 6, 0);

        StronglyConnectedComponents scc = new StronglyConnectedComponents();
        List<Set<Vertex<Integer>>> result = scc.getStronglyConnectedComponents(graph);

        //print the result
        result.forEach(set -> {
            set.forEach(v -> System.out.print(v.data + " "));
            System.out.println();
        });
    }
}
