package dynamicProgramming;

public class KnapsackProblem {

	public static void main(String args[]) {
		KnapsackProblem knapsack = new KnapsackProblem();
		int valueArr[] = { 22, 20, 15, 30, 24, 54, 21, 32, 18, 25 };
		int weightArr[] = { 4, 2, 3, 5, 5, 6, 9, 7, 8, 10 };
		int maxValue = knapsack.fetchMaxValueForGivenWeight(valueArr, weightArr, 30);
		System.out.println(maxValue);
	}

	public int fetchMaxValueForGivenWeight(int valueArr[], int weightArr[], int totalWeight) {
		int arr[][] = new int[valueArr.length + 1][totalWeight + 1];
		for (int i = 0; i <= valueArr.length; i++) {
			for (int j = 0; j <= totalWeight; j++) {
				if (i == 0 || j == 0) {
					arr[i][j] = 0;
					continue;
				}
				if (j - weightArr[i - 1] >= 0) {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - weightArr[i - 1]] + valueArr[i - 1]);
				} else {
					arr[i][j] = arr[i - 1][j];
				}
			}
		}
		return arr[valueArr.length][totalWeight];
	}

}
