package impl.heap;


import java.util.Arrays;

public class MaxHeap {
    private final int SIZE = 10;
    private int[] arr;
    private int currSize;

    public MaxHeap() {
        this.currSize = 0;
        this.arr = new int[SIZE];
        Arrays.fill(arr, -1);
    }

    public int getParent(int i) {
        return i / 2;
    }

    public int getLeftChild(int i) {
        return (2 * i + 1 < SIZE) ? 2 * i + 1 : -1;
    }

    public int getRightChild(int i) {
        return (2 * i + 2 < SIZE) ? 2 * i + 2 : -1;
    }

    public boolean add(int i) {
        if (currSize >= SIZE - 1) {
            return false;
        }
        this.arr[currSize++] = i;
        heapify(currSize - 1);
        return true;
    }

    public int remove() {
        if (currSize < 0) {
            return -1;
        }
        int value = arr[0];
        arr[0] = arr[currSize - 1];
        arr[currSize - 1] = -1;
        currSize--;
        percolate(0);
        return value;
    }

    public void heapify(int i) {
        if (i < 0 || i >= SIZE) {
            return;
        }
        int parent = getParent(i);
        if (arr[parent] < arr[i]) {
            swap(i, parent);
            heapify(parent);
        }
    }

    private void swap(int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    public void percolate(int parent) {
        int left = getLeftChild(parent);
        int right = getRightChild(parent);
        if (left != -1) {
            if (arr[parent] < arr[left]) {
                swap(parent, left);
                percolate(left);
            }
        }
        if (right != -1) {
            if (arr[parent] < arr[right]) {
                swap(parent, right);
                percolate(right);
            }
        }
    }

    public void print() {
        Arrays.stream(this.arr).forEach(e -> {
            System.out.print(e + " ");
        });
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(3);
        maxHeap.add(4);
        maxHeap.add(5);
        maxHeap.add(6);
        maxHeap.add(7);
        maxHeap.add(8);
        maxHeap.print();
        System.out.println();

        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.print();
    }

}
