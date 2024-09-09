package impl.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] input, int k) {
        Map<Integer, int[]> map = new HashMap<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < input.length; i++) {
            map.put(input[i], map.getOrDefault(input[i], new int[]{input[i], 0}));
            int[] valFreq = map.get(input[i]);
            if (valFreq[1] > 1) {
                priorityQueue.remove(valFreq);
            }
            valFreq = new int[]{valFreq[0], valFreq[1] + 1};
            priorityQueue.offer(valFreq);
            map.put(valFreq[0], valFreq);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll()[0];
        }
        return result;
    }

}
