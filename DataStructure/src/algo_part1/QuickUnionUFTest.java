package algo_part1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QuickUnionUFTest {

	@Test
	public void TestConnected() {
		int size = 10;
		QuickUnionUF uf = new QuickUnionUF(size);
		uf.union(9, 1);
		uf.union(6, 2);
		uf.union(5, 3);
		uf.union(2, 5);
		uf.union(0, 8);
		uf.union(1, 7);
		uf.union(5, 9);
		assertTrue(uf.isConnected(6, 2) == true);
		assertTrue(uf.isConnected(5, 3) == true);
		assertTrue(uf.isConnected(9, 2) == true);
	}

	@Test
	public void TestNotConnected() {
		int size = 10;
		QuickUnionUF uf = new QuickUnionUF(size);
		uf.union(9, 1);
		uf.union(6, 2);
		uf.union(5, 3);
		uf.union(2, 5);
		uf.union(0, 8);
		uf.union(1, 7);
		uf.union(5, 9);
		assertTrue(uf.isConnected(9, 0) == false);
		assertTrue(uf.isConnected(4, 6) == false);
	}
}
