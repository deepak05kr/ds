package algo_part1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BitonicSearchTest {
	@Test
	public void searchAscendingTest() {
		int arr1[] = { -3, 6, 8, 20 };
		int arr2[] = { 5, 6, 7, 8, 9, 10 };

		BitonicSearch bs = new BitonicSearch();
		assertEquals(bs.searchInAscendingArr(arr1, 0, arr1.length - 1, -3), 0);
		assertEquals(bs.searchInAscendingArr(arr1, 0, arr1.length - 1, 20), 3);
		assertEquals(bs.searchInAscendingArr(arr1, 0, arr1.length - 1, 8), 2);

		assertEquals(bs.searchInAscendingArr(arr2, 0, arr2.length - 1, 5), 0);
		assertEquals(bs.searchInAscendingArr(arr2, 0, arr2.length - 1, 10), 5);
		assertEquals(bs.searchInAscendingArr(arr2, 0, arr2.length - 1, 8), 3);
	}

	@Test
	public void searchDescendingTest() {
		int arr1[] = { 20, 17, 5, 1 };
		int arr2[] = { 10, 8, 7, 5, 2, 1 };

		BitonicSearch bs = new BitonicSearch();
		assertEquals(bs.searchInDescendingArr(arr1, 0, arr1.length - 1, 20), 0);
		assertEquals(bs.searchInDescendingArr(arr1, 0, arr1.length - 1, 1), 3);
		assertEquals(bs.searchInDescendingArr(arr1, 0, arr1.length - 1, 5), 2);

		assertEquals(bs.searchInDescendingArr(arr2, 0, arr2.length - 1, 1), 5);
		assertEquals(bs.searchInDescendingArr(arr2, 0, arr2.length - 1, 10), 0);
		assertEquals(bs.searchInDescendingArr(arr2, 0, arr2.length - 1, 8), 1);
		assertEquals(bs.searchInDescendingArr(arr2, 0, arr2.length - 1, 5), 3);
	}
	@Test
	public void getMaxValueIndexTest() {
		int arr1[] = { -3, 6, 8, 20, 17, 5, 1 };
		int arr2[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		BitonicSearch bs = new BitonicSearch();
		assertEquals(bs.getMaxValueIndex(arr1, 0, arr1.length-1), 3);
		assertEquals(bs.getMaxValueIndex(arr2, 0, arr2.length-1), 5);
		
		int arr3[] = { -3, 20, 17, 5, 1 };
		int arr4[] = { 5, 6, 7, 8, 9, 10, 1 };
		assertEquals(bs.getMaxValueIndex(arr3, 0, arr3.length-1), 1);
		assertEquals(bs.getMaxValueIndex(arr4, 0, arr4.length-1), 5);
		
	}
}
