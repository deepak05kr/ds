package graph;

import org.junit.Assert;
import org.junit.Test;
import unionfind.UnionFind;

public class TestUnionFind {
    @Test
    public void testUnionFind() {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        int[][] union = {{1, 2}, {2, 5}, {5, 6}, {6, 7}, {3, 8}, {8, 9}};
        uf.populateUnionFindArr(union);
        Assert.assertTrue(uf.connected(1, 5));
        Assert.assertTrue(uf.connected(5, 7));
        Assert.assertFalse(uf.connected(4, 9));
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        Assert.assertTrue(uf.connected(4, 9));
    }
}
