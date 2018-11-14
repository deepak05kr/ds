package customTree;

import org.junit.Test;

import dynamicProgramming.LongestCommonSubsequence;
import junit.framework.Assert;

public class LongestCommonSubsequenceTest {

	@Test
	public void LongestCommonSubsequenceTest() {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String input = "abcdaf";
		String match = "acbcf";
		int maxSubsequenceLength = lcs.getLongestCommonSubsequenceLength(input.toCharArray(), match.toCharArray());
		Assert.assertEquals(4, maxSubsequenceLength);
	}

	@Test
	public void LongestCommonSubsequenceTest2() {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String input = "ABCDGHLQR";
		String match = "AEDPHR";
		int maxSubsequenceLength = lcs.getLongestCommonSubsequenceLength(input.toCharArray(), match.toCharArray());
		Assert.assertEquals(4, maxSubsequenceLength);
	}

}
