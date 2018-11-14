package dynamicProgramming;

import org.junit.Test;

import junit.framework.Assert;

public class MatrixMultiplicationCostTest {
	@Test
	public void TestMatrixMultiplication() {
		MatrixMultiplicationCost mmc = new MatrixMultiplicationCost();
		int arr[] = { 4, 2, 3, 5, 3 };
		int cost = mmc.findMinMatrixMultiplicationCost(arr);
		Assert.assertEquals(84, cost);

	}

	@Test
	public void TestMatrixMultiplication2() {
		MatrixMultiplicationCost mmc = new MatrixMultiplicationCost();
		int arr[] = { 2, 3, 6, 4, 5 };
		int cost = mmc.findMinMatrixMultiplicationCost(arr);
		Assert.assertEquals(124, cost);

	}
}
