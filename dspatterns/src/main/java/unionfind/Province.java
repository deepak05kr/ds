package unionfind;

public class Province {
    int[] arr;
    int[] rank;

    public Province(int size) {
        arr = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (arr[x] != x) {
            arr[x] = find(arr[x]);
        }
        return arr[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                arr[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                arr[rootX] = rootY;
            } else {
                arr[rootX] = rootY;
                rank[rootY] = rank[rootY] + 1;
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int numOfComponents = isConnected.length;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && find(i) != find(j)) {
                    union(i, j);
                    numOfComponents--;
                }
            }
        }
        return numOfComponents;
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Province solution = new Province(isConnected.length);
        int circleNum = solution.findCircleNum(isConnected);
        System.out.println(circleNum);
    }
}