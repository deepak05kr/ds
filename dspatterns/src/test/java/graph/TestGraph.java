package graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class TestGraph {


    @Test
    public void testAdjacentVerticesUndirected() {
        Graph graph = TestUtil.createUndirectedGraph();
        Set<Integer> adjacencentVertices = graph.getAdjacencentVertices(1);
        Assert.assertTrue(adjacencentVertices.contains(2));
        Assert.assertTrue(adjacencentVertices.contains(3));
        Assert.assertTrue(adjacencentVertices.contains(4));

        adjacencentVertices = graph.getAdjacencentVertices(2);
        Assert.assertTrue(adjacencentVertices.contains(1));
        Assert.assertTrue(adjacencentVertices.contains(4));
        Assert.assertTrue(adjacencentVertices.contains(5));
        Assert.assertTrue(adjacencentVertices.contains(6));
        Assert.assertTrue(adjacencentVertices.contains(3));


        adjacencentVertices = graph.getAdjacencentVertices(3);
        Assert.assertTrue(adjacencentVertices.contains(1));
        Assert.assertTrue(adjacencentVertices.contains(4));
        Assert.assertTrue(adjacencentVertices.contains(5));
        Assert.assertTrue(adjacencentVertices.contains(6));
        Assert.assertTrue(adjacencentVertices.contains(2));

    }

    @Test
    public <T> void testAdjacentVerticesWeightedUndirected() {
        Graph graph = TestUtil.createWeightedUndirectedGraph();
        List<Edge<T>> edgeList = graph.getAllEdges();
        for (Edge<T> edge : edgeList) {
            Assert.assertTrue(graph.containsEdge(edge));
        }
    }

    @Test
    public void testAdjacentVerticesDirected() {
        Graph graph = TestUtil.createDirectedGraph();
        Set<Integer> adjacencentVertices = graph.getAdjacencentVertices(1);
        Assert.assertTrue(adjacencentVertices.contains(2));
        Assert.assertTrue(adjacencentVertices.contains(3));
        Assert.assertTrue(adjacencentVertices.contains(4));

        adjacencentVertices = graph.getAdjacencentVertices(2);
        Assert.assertTrue(adjacencentVertices.contains(4));
        Assert.assertTrue(adjacencentVertices.contains(5));
        Assert.assertTrue(adjacencentVertices.contains(6));

        Assert.assertTrue(!adjacencentVertices.contains(3));


        adjacencentVertices = graph.getAdjacencentVertices(3);
        Assert.assertTrue(adjacencentVertices.contains(5));

        Assert.assertTrue(!adjacencentVertices.contains(1));
        Assert.assertTrue(!adjacencentVertices.contains(4));
        Assert.assertTrue(!adjacencentVertices.contains(6));
        Assert.assertTrue(!adjacencentVertices.contains(2));

    }
}
