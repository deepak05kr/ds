package twopointers;

//{-2,1,-3,4,-1,2,1,-5,4}
public class MaxSumSubArray {
    public int[] maxSumSubArray(int[] arr) {
        int start = 0, end = 0;
        int sum = 0, i = 0, maxSum = 0;
        while (i < arr.length) {
            sum = sum + arr[i];
            if (maxSum < sum) {
                maxSum = sum;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
                start = i;
                end = i;
            }
            i++;

        }
        return new int[]{start + 1, end};
    }

    public static void main(String[] args) {
        MaxSumSubArray maxSumSubArray = new MaxSumSubArray();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] result = maxSumSubArray.maxSumSubArray(arr);
        System.out.println(result[0] + ", " + result[1]);
    }
}
