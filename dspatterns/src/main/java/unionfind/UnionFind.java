package unionfind;

public class UnionFind {
    int[] arr;

    public UnionFind(int size) {
        arr = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            arr[i] = i;
        }
    }

    public int find(int x) {
        if (x == arr[x]) {
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            arr[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return arr[x] == arr[y];
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        int[][] union = {{1, 2}, {2, 5}, {5, 6}, {6, 7}, {3, 8}, {8, 9}};
        for (int[] input : union) {
            uf.union(input[0], input[1]);
        }
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // tr
    }
}
