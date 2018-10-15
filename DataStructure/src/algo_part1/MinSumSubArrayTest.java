package algo_part1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinSumSubArrayTest {
	@Test
	public void TestClassTest1() {
		int[] arr = {50,50,123,121,987};
		MinSumSubArray tc = new MinSumSubArray();
		assertEquals(100, tc.getMinSum(arr));
	}
	@Test
	public void TestClassTest2() {
		int[] arr = {-50,50,123,121,987,-25,30};
		MinSumSubArray tc = new MinSumSubArray();
		assertEquals(-45, tc.getMinSum(arr));
	}
	@Test
	public void TestClassTest3() {
		int[] arr = {-100000000,50};
		MinSumSubArray tc = new MinSumSubArray();
		assertEquals(-100000000, tc.getMinSum(arr));
	}
	
}
