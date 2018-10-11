//Union-find with specific canonical element. Add a method \mathtt{find()}find() to the union-find data type so 
//that \mathtt{find(i)}find(i) returns the largest element in the connected component containing ii. The operations, 
//\mathtt{union()}union(), \mathtt{connected()}connected(), and \mathtt{find()}find() should all take logarithmic 
//time or better.
//For example, if one of the connected components is \{1, 2, 6, 9\}{1,2,6,9}, then the \mathtt{find()}find() method 
//should return 99 for each of the four elements in the connected components.

package algo_part1;

public class QuickUnionFind {
	private int[] id;
	private int[] sz;

	public QuickUnionFind(int size) {
		id = new int[size];
		sz = new int[size];
		for (int i = 0; i < size; i++) {
			id[i] = i;
		}

		for (int i = 0; i < size; i++) {
			sz[i] = 1;
		}
	}

	private int getRoot(int index) {
		while (id[index] != index) {
			index = id[index];
		}
		return index;
	}

	public boolean isConnected(int p, int q) {
		return getRoot(p) == getRoot(q);
	}

	public void union(int p, int q) {
		int i = getRoot(p);
		int j = getRoot(q);
		if (sz[i] < sz[j]) {
			if (i < j) {
				id[i] = j;
				sz[j] = sz[j] + sz[i];
			} else {
				id[j] = i;
				sz[i] = sz[i] + sz[j];
			}
		} else {
			if (j > i) {
				id[i] = j;
				sz[j] = sz[j] + sz[i];
			} else {
				id[j] = i;
				sz[i] = sz[i] + sz[j];
			}
		}
	}

	public int find(int p) {
		while (id[p] != p) {
			p = id[p];
		}
		return p;
	}

	public void printArray() {
		System.out.println("Printing index");
		for (int i = 0; i < id.length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Printing id array");
		for (int i = 0; i < id.length; i++) {
			System.out.print(id[i] + " ");
		}
		System.out.println();
		System.out.println("Printing sz array");
		for (int i = 0; i < id.length; i++) {
			System.out.print(sz[i] + " ");
		}
	}

	public static void main(String args[]) {
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
		uf.printArray();
	}
}
