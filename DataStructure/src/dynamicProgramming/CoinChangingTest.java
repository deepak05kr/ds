package dynamicProgramming;

import org.junit.Test;

import junit.framework.Assert;

public class CoinChangingTest {

	@Test
	public void CoinChangingTest1() {
		CoinChanging cc = new CoinChanging();
		int total = 11;
		int input[] = { 1, 5, 6, 8 };
		int result = cc.minNumberOfCoins(input, total);
		Assert.assertEquals(2, result);
	}

	@Test
	public void CoinChangingTest2() {
		CoinChanging cc = new CoinChanging();
		int total = 2;
		int input[] = { 1, 5, 6, 8 };
		int result = cc.minNumberOfCoins(input, total);
		Assert.assertEquals(2, result);
	}

	@Test
	public void CoinChangingTest3() {
		CoinChanging cc = new CoinChanging();
		int total = 14;
		int input[] = { 1, 5, 6, 8 };
		int result = cc.minNumberOfCoins(input, total);
		Assert.assertEquals(2, result);
	}

	@Test
	public void CoinChangingTest4() {
		CoinChanging cc = new CoinChanging();
		int total = 7;
		int input[] = { 1, 5, 6, 8 };
		int result = cc.minNumberOfCoins(input, total);
		Assert.assertEquals(2, result);
	}
}
