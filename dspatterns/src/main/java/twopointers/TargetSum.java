package twopointers;

import java.util.*;

public class TargetSum {
    public int[] findPair(Integer[] nums, int target) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = frequencyMap.getOrDefault(nums[i], 0);
            frequencyMap.put(nums[i], value + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] != nums[i] && frequencyMap.containsKey(target - nums[i])) {
                return new int[]{nums[i], target - nums[i]};
            } else {
                Integer frequency = frequencyMap.getOrDefault(nums[i], 0);
                if (frequency != 0 && frequency >= 2 && 2 * frequency == target) {
                    return new int[]{nums[i], nums[i]};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        Integer[] arr = {3, 5, 2, 8, 11};
        int[] pair = targetSum.findPair(arr, 10);
        System.out.println(pair[0] + ", " + pair[1]);
    }
}
