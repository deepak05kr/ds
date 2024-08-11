package graph;

import dijkstra.Dijkstra;
import org.junit.Assert;
import org.junit.Test;

public class TestDijkestra {
    @Test
    public void testShortestPathCost1() {
        Dijkstra dijkstra = new Dijkstra();
        int[][] input = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int cost = dijkstra.shortestPathCost(input, 0, 3);
        Assert.assertEquals(cost, 5);

    }

    @Test
    public void testShortestPathCost2() {
        Dijkstra dijkstra = new Dijkstra();
        int[][] input2 = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        int cost = dijkstra.shortestPathCost(input2, 0, 3);
        Assert.assertEquals(6, cost);
    }
}
