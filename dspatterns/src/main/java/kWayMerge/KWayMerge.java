package kWayMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KWayMerge {
    public List<Integer> mergeSorted(List<List<Integer>> input) {
        PriorityQueue<DataIdx> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.getData(), b.getData()));
        for (int i = 0; i < input.size(); i++) {
            priorityQueue.add(new DataIdx(input.get(i).get(0), i, 0));
        }
        List<Integer> result = new ArrayList<>();

        while (!priorityQueue.isEmpty()) {
            DataIdx dataIdx = priorityQueue.poll();
            result.add(dataIdx.getData());
            int arrLen = input.get(dataIdx.getListIdx()).size();
            if (dataIdx.getIndex() < arrLen - 1) {
                DataIdx newDataIdx = new DataIdx(input.get(dataIdx.getListIdx()).get(dataIdx.getIndex() + 1), dataIdx.getListIdx(), dataIdx.getIndex() + 1);
                priorityQueue.offer(newDataIdx);
            }
        }
        return result;

    }

    class DataIdx {
        private int data;
        private int listIdx;
        private int index;

        public DataIdx(int data, int listIdx, int index) {
            this.data = data;
            this.listIdx = listIdx;
            this.index = index;
        }

        public int getData() {
            return data;
        }

        public int getListIdx() {
            return listIdx;
        }

        public int getIndex() {
            return index;
        }
    }
}
