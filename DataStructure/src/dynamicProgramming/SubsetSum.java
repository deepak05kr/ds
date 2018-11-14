package dynamicProgramming;

public class SubsetSum {

	public static void main(String args[]) {
		SubsetSum ss = new SubsetSum();
		int sum = 14;
		int input[] = { 2, 3, 5, 7, 10 };
		boolean result = ss.calculateSum(input, sum);
		System.out.println(result);
	}

	public  boolean calculateSum(int[] input, int sum) {
		boolean[][] arr = new boolean[input.length][sum + 1];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j <= sum; j++) {
				if (j == 0) {
					arr[i][j] = true;
				}
				if (j == input[i] || (i > 0 && arr[i - 1][j] == true)) {
					arr[i][j] = true;
				} else if (i > 0 && (j - input[i]) > 0 && arr[i - 1][j - input[i]] == true) {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
			}
		}
		return arr[input.length - 1][sum];
	}

}
