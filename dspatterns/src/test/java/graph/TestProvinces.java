package graph;

import org.junit.Assert;
import org.junit.Test;
import unionfind.Province;

public class TestProvinces {
    @Test
    public void testProvinces() {
        int[][] isconected = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        Province provincesCount = new Province(isconected.length);
        int circleNum = provincesCount.findCircleNum(isconected);
        Assert.assertEquals(1, circleNum);

        int[][] isconected2 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Province provincesCount2 = new Province(isconected2.length);
        circleNum = provincesCount2.findCircleNum(isconected2);
        Assert.assertEquals(2, circleNum);
    }
}
