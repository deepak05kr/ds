package algo_part1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class _3SumProblemTest {

	@Test
	public void combinationTest1() {
		int[] sortedInput = { -40, -20, -10, 0, 5, 10, 30, 40 };
		_3SumProblem obj = new _3SumProblem();
		assertTrue(obj.countCombinations(sortedInput) == 4);
	}

	@Test
	public void combinationTest2() {
		int[] sortedInput = { -25, -10, -7, -3, 2, 4, 8, 10 };
		_3SumProblem obj = new _3SumProblem();
		assertTrue(obj.countCombinations(sortedInput) == 2);
	}
}
