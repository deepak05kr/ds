package heap;

import impl.heap.TopKFrequent;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestTopKFrequent {
    @Test
    public void testTopKFrequent() {
        int[] input = {1, 2, 3, 4, 5, 1, 2, 4, 5, 2, 5, 4, 5, 2, 6};
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] result = topKFrequent.topKFrequent(input, 3);
        int[] expected = {5, 2, 4};
        Assert.assertArrayEquals(expected, result);
        // 1 - 2
        // 2 - 4
        // 3 - 1
        // 4 - 3
        // 5 - 4
        // 6  - 1
    }

    @Test
    public void testTopKFrequent2() {
        int[] input = {1, 2, 3, 4, 5, 1, 2, 4, 5, 2, 5, 1, 5, 2, 6};
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] result = topKFrequent.topKFrequent(input, 3);
        int[] expected = {5, 2, 1};
        Assert.assertArrayEquals(expected, result);
        // 1 - 3
        // 2 - 4
        // 3 - 1
        // 4 - 2
        // 5 - 4
        // 6  - 1
    }
}
