package dynamicProgramming;

import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingSubsequenceTest {
	@Test
	public void LongestIncreasingSubsequenceTest1() {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] input = { 3, 4, -1, 0, 6, 2, 3 };
		int result = lis.getLongestSequenceLength(input);
		Assert.assertEquals(4, result);
	}

	@Test
	public void LongestIncreasingSubsequenceTest2() {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] input = { 2, 5, 1, 8, 3 };
		int result = lis.getLongestSequenceLength(input);
		Assert.assertEquals(3, result);
	}
}
