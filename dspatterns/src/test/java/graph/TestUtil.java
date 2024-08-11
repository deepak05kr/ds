package graph;

public class TestUtil {
    public static Graph createUndirectedGraph() {
        Graph undirectedGraph = new Graph(false);
        undirectedGraph.addEdge(1, 2, 0);
        undirectedGraph.addEdge(1, 3, 0);
        undirectedGraph.addEdge(1, 4, 0);
        undirectedGraph.addEdge(2, 3, 0);
        undirectedGraph.addEdge(2, 4, 0);
        undirectedGraph.addEdge(2, 5, 0);
        undirectedGraph.addEdge(2, 6, 0);
        undirectedGraph.addEdge(3, 1, 0);
        undirectedGraph.addEdge(3, 4, 0);
        undirectedGraph.addEdge(3, 5, 0);
        undirectedGraph.addEdge(3, 6, 0);
        undirectedGraph.addEdge(4, 1, 0);
        undirectedGraph.addEdge(4, 2, 0);
        undirectedGraph.addEdge(5, 6, 0);
        return undirectedGraph;
    }

    public static Graph createWeightedUndirectedGraph() {
        Graph undirectedGraph = new Graph(false);
        undirectedGraph.addEdge(1, 2, 10);
        undirectedGraph.addEdge(1, 3, 11);
        undirectedGraph.addEdge(1, 4, 5);
        undirectedGraph.addEdge(2, 3, 16);
        undirectedGraph.addEdge(2, 4, 18);
        undirectedGraph.addEdge(2, 5, 7);
        undirectedGraph.addEdge(2, 6, 21);
        undirectedGraph.addEdge(3, 1, 11);
        undirectedGraph.addEdge(3, 4, 15);
        undirectedGraph.addEdge(3, 5, 55);
        undirectedGraph.addEdge(3, 6, 22);
        undirectedGraph.addEdge(4, 1, 5);
        undirectedGraph.addEdge(4, 2, 18);
        undirectedGraph.addEdge(5, 6, 100);
        return undirectedGraph;
    }

    public static Graph createDirectedGraph() {
        Graph directedGraph = new Graph(true);
        directedGraph.addEdge(1, 2, 0);
        directedGraph.addEdge(1, 3, 0);
        directedGraph.addEdge(1, 4, 0);

        directedGraph.addEdge(2, 4, 0);
        directedGraph.addEdge(2, 5, 0);
        directedGraph.addEdge(2, 6, 0);

        directedGraph.addEdge(3, 5, 0);

        directedGraph.addEdge(5, 6, 0);
        return directedGraph;
    }
}
