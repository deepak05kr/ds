package algo_part1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QuickUnionFindTest {

	@Test
	public void TestConnected() {
		int size = 10;
		QuickUnionFind uf = new QuickUnionFind(size);
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
		QuickUnionFind uf = new QuickUnionFind(size);
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
	@Test
	public void TestFind() {
		int size = 10;
		QuickUnionFind uf = new QuickUnionFind(size);
		uf.union(4, 5);
		uf.union(3, 4);
		uf.union(2, 3);
		uf.union(1, 2);
		uf.union(0, 1);

		uf.union(8, 9);
		uf.union(7, 8);
		uf.union(6, 7);
		
		assertTrue(uf.find(0) == 5);
		assertTrue(uf.find(2) == 5);
		assertTrue(uf.find(4) == 5);
		assertTrue(uf.find(5) == 5);
		assertTrue(uf.find(9) == 9);
		assertTrue(uf.find(7) == 9);
		assertTrue(uf.find(6) == 9);
	}
	
}
