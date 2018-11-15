package dynamicProgramming;

public class LongestIncreasingSubsequence {

	public static void main(String args[]) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] input = { 3, 4, -1, 0, 6, 2, 3 };

		int result = lis.getLongestSequenceLength(input);
		System.out.println(result);
	}

	public  int getLongestSequenceLength(int[] input) {
		int arr[] = new int[input.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}
		for (int index = 0; index < input.length - 1; index++) {
			int i = index + 1;
			int j = 0;
			while (j < i) {
				if (input[i] > input[j]) {
					arr[i] = Math.max(arr[j] + 1, arr[i]);
				}
				j++;
			}
		}
		int min = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (min < arr[i]) {
				min = arr[i];
			}
		}
		return min;

	}

}
