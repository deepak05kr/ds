package impl.heap;

import java.util.PriorityQueue;

public class TopK {
    public int[] getTopK(int[] input, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int i = 0; i < input.length; i++) {
            if (priorityQueue.size() == k) {
                if (input[i] < priorityQueue.peek().intValue()) {
                    continue;
                }
                priorityQueue.poll();
            }
            priorityQueue.offer(input[i]);
            priorityQueue.stream().forEach(e -> {
                System.out.print(e + " ");
            });
            System.out.println();
        }
        int[] array = priorityQueue.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 12, 2, 11};
        TopK topK = new TopK();
        topK.getTopK(arr, 3);

    }
}
