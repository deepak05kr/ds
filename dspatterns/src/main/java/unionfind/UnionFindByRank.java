package unionfind;

public class UnionFindByRank {
    int[] arr;
    int[] rank;

    public UnionFindByRank(int size) {
        arr = new int[size + 1];
        rank = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            arr[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                arr[rootX] = rootY;
            } else if (rank[rootX] < rank[rootY]) {
                arr[rootY] = rootX;
            } else {
                arr[rootX] = rootY;
                rank[rootY] = rank[rootY] + 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
