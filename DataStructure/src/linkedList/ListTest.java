package linkedList;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ListTest {
	@Test
	public void StringAddTest() {
		List<String> stringList = new List<>();
		stringList.add("a");
		assertTrue("a".equals(stringList.getHead().getData()));
		stringList.add("b");
		assertTrue("b".equals(stringList.getHead().getNext().getData()));
		stringList.add("c");
		assertTrue("c".equals(stringList.getHead().getNext().getNext().getData()));
	}

	@Test
	public void intAddTest() {
		List<Integer> intList = new List<>();
		intList.add(1);
		assertTrue(1 - intList.getHead().getData() == 0);
		intList.add(2);
		assertEquals(2, intList.getHead().getNext().getData());
		intList.add(3);
		assertEquals(3, intList.getHead().getNext().getNext().getData());
	}

}
