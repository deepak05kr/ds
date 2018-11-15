package dynamicProgramming;

public class CoinChanging {

	public static void main(String args[]) {
		CoinChanging cc = new CoinChanging();
		int total = 11;
		int input[] = { 1, 5, 6, 8 };
		int result = cc.minNumberOfCoins(input, total);
		System.out.println(result);
	}

	public int minNumberOfCoins(int[] input, int sum) {
		int[][] arr = new int[input.length][sum + 1];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j <= sum; j++) {
				if (j == 0) {
					arr[i][j] = 0;
					continue;
				}
				if (j < input[i]) {
					arr[i][j] = arr[i - 1][j];
				} else {
					if (i > 0) {
						arr[i][j] = Math.min(arr[i - 1][j], arr[i - 1][j % input[i]] + j / input[i]);
					} else {
						arr[i][j] = j / input[i];
					}

				}
			}
		}
		return arr[input.length - 1][sum];
	}

}
