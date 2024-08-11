package unionfind;

public class UnionFind {
    private int[] arr;

    public UnionFind(int arrSize) {
        arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = i;
        }
    }

    // values starting from 0
    public void populateUnionFindArr(int[][] union) {
        for (int i = 0; i < union.length; i++) {
            if (union[i][0] > union[i][1]) {
                arr[union[i][0]] = arr[union[i][1]];
            } else {
                arr[union[i][1]] = arr[union[i][0]];
            }
        }
    }

    public void union(int val1, int val2) {
        if (val1 > val2) {
            arr[val1] = val2;
        } else {
            arr[val2] = val1;
        }
    }

    public boolean connected(int val1, int val2) {
        int root1 = findRoot(val1);
        int root2 = findRoot(val2);
        if (root1 == root2 && root2 != -1) {
            return true;
        }
        return false;
    }

    public int findRoot(int val) {
        if (val < 0 || val > arr.length) {
            return -1;
        }
        int index = arr[val];
        while (index != arr[val]) {
            index = arr[index];
        }
        return index;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        int[][] union = {{1, 2}, {2, 5}, {5, 6}, {6, 7}, {3, 8}, {8, 9}};
        uf.populateUnionFindArr(union);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
