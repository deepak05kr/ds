package dynamicProgramming;

import org.junit.Test;

import junit.framework.Assert;

public class SubsetSumTest {
	@Test
	public void SubsetSumTest1() {
		SubsetSum ss = new SubsetSum();
		int sum = 14;
		int input[] = { 2, 3, 5, 7, 10 };
		boolean result = ss.calculateSum(input, sum);
		Assert.assertEquals(true, result);
		result = ss.calculateSum(input, 10);
		Assert.assertEquals(true, result);
		result = ss.calculateSum(input, 1);
		Assert.assertEquals(false, result);
		result = ss.calculateSum(input, 21);
		Assert.assertEquals(false, result);
		result = ss.calculateSum(input, 22);
		Assert.assertEquals(true, result);
	}
}
