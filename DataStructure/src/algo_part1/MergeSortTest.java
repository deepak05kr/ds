package algo_part1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {

	@Test
	public void MergeSortTest1() {
		Integer[] arr1 = { 1, 10, -1, 45 };
		Integer[] sortedArr1 = { -1, 1, 10, 45 };
		MergeSort ms = new MergeSort();
		ms.sort(arr1);
		assertArrayEquals(arr1, sortedArr1);

	}

	@Test
	public void MergeSortTest2() {
		Integer[] arr1 = { 1, -1 };
		Integer[] sortedArr1 = { -1, 1 };
		MergeSort ms = new MergeSort();
		ms.sort(arr1);
		assertArrayEquals(arr1, sortedArr1);

	}
}
