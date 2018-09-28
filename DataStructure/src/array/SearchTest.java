package array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class SearchTest {
	SearchingElement obj = new SearchingElement();

	@Test
	public void LinearSearchTest() {
		int[] inputArr = { 10, 20, 80, 30, 60, 50, 110, 100, 130, 170 };
		
		int elementToSearch = 1;
		assertEquals(-1, obj.LinearSearch(inputArr, elementToSearch));
		
		elementToSearch = 175;
		assertEquals(-1, obj.LinearSearch(inputArr, elementToSearch));
		
		elementToSearch = 10;
		assertEquals(0, obj.LinearSearch(inputArr, elementToSearch));
		
		elementToSearch = 50;
		assertEquals(5, obj.LinearSearch(inputArr, elementToSearch));
		
		elementToSearch = 170;
		assertEquals(9, obj.LinearSearch(inputArr, elementToSearch));
		
	}
	@Test
	public void BinarySearchTest() {
		int[] inputArr = { 10, 20, 30, 50, 60, 80, 100, 110, 130, 170 };
		
		int elementToSearch = 1;
		assertEquals(-1, obj.LinearSearch(inputArr, elementToSearch));
		
		elementToSearch = 175;
		assertEquals(-1, obj.LinearSearch(inputArr, elementToSearch));
		
		elementToSearch = 10;
		assertEquals(0, obj.LinearSearch(inputArr, elementToSearch));
		
		elementToSearch = 50;
		assertEquals(3, obj.LinearSearch(inputArr, elementToSearch));
		
		elementToSearch = 170;
		assertEquals(9, obj.LinearSearch(inputArr, elementToSearch));
		
	}
}
