package heap;

import impl.heap.TopK;
import org.junit.Assert;
import org.junit.Test;

public class TestTopK {
    @Test
    public void testTopK() {
        int[] arr = {3, 1, 5, 12, 2, 11};
        TopK topK = new TopK();
        int[] result = topK.getTopK(arr, 3);
        int[] expected = {5, 12, 11};
        Assert.assertArrayEquals(expected, result);

    }

}
