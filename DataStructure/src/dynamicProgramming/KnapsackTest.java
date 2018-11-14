package dynamicProgramming;

import org.junit.Test;

import junit.framework.Assert;

public class KnapsackTest {
	@Test
	public void test1() {
		KnapsackProblem knapsack = new KnapsackProblem();
		int valueArr[] = { 22, 20, 15, 30, 24, 54, 21, 32, 18, 25 };
		int weightArr[] = { 4, 2, 3, 5, 5, 6, 9, 7, 8, 10 };
		int totalWeight = 30;
		int maxValue = knapsack.fetchMaxValueForGivenWeight(valueArr, weightArr, totalWeight);
		Assert.assertEquals(182, maxValue);
	}

	@Test
	public void test2() {
		KnapsackProblem knapsack = new KnapsackProblem();
		int valueArr[] = { 1, 4, 5, 7 };
		int weightArr[] = { 1, 3, 4, 5 };
		int totalWeight = 7;
		int maxValue = knapsack.fetchMaxValueForGivenWeight(valueArr, weightArr, totalWeight);
		Assert.assertEquals(9, maxValue);
	}

}
