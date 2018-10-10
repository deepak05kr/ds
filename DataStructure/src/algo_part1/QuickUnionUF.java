package algo_part1;

//Find query. Check if two objects are in the same component => isConnected
//Union command. Replace components containing two objects with their union. => union  

public class QuickUnionUF {
	private int[] id;
	private int[] sz;

	public QuickUnionUF(int size) {
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
			id[i] = j;
			sz[j] = sz[j] + sz[i];
		} else {
			id[j] = i;
			sz[i] = sz[i] + sz[j];
		}
	}

	public void printArr() {
		for (int i = 0; i < id.length; i++) {
			System.out.print(id[i] + " ");
		}
	}

	public static void main(String args[]) {
		int size = 10;
		QuickUnionUF uf = new QuickUnionUF(size);
		System.out.println(uf.isConnected(1, 2));
		uf.union(9, 1);
		uf.union(6, 2);
		uf.union(5, 3);
		uf.union(2, 5);
		uf.union(0, 8);
		uf.union(1, 7);
		uf.union(5, 9);
		System.out.println(uf.isConnected(9, 4));
		System.out.println(uf.isConnected(6, 2));
//		uf.printArr();
	}
}
