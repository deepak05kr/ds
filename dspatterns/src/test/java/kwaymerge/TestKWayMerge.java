package kwaymerge;

import kWayMerge.KWayMerge;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestKWayMerge {
    @Test
    public void testKwayMerge() {
        List<Integer> list1 = new ArrayList<>(Arrays.stream(new int[]{1, 3, 4, 5, 42}).boxed().toList());
        List<Integer> list2 = new ArrayList<>(Arrays.stream(new int[]{2, 6, 88}).boxed().toList());
        List<Integer> list3 = new ArrayList<>(Arrays.stream(new int[]{3, 6, 17}).boxed().toList());
        List<Integer> list4 = new ArrayList<>(Arrays.stream(new int[]{10, 13, 14}).boxed().toList());

        List<List<Integer>> input = new ArrayList<>();
        input.add(list1);
        input.add(list2);
        input.add(list3);
        input.add(list4);

        KWayMerge kWayMerge = new KWayMerge();
        List<Integer> result = kWayMerge.mergeSorted(input);
        int[] expected = new int[]{1, 2, 3, 3, 4, 5, 6, 6, 10, 13, 14, 17, 42, 88};

        Assert.assertArrayEquals(expected, result.stream().mapToInt(Integer::intValue).toArray());
    }
}
