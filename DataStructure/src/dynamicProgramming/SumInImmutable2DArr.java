package dynamicProgramming;

public class SumInImmutable2DArr {

	public static void main(String args[]) {
		SumInImmutable2DArr obj = new SumInImmutable2DArr();
		int input[][] = 
			  { { 2, 0, -3, 4 }, 
				{ 6, 3, 2, -1 }, 
				{ 5, 4, 7, 3 }, 
				{ 2, -6, 8, 1 } 
			  };
		int[][] result = obj.calculateSum(input);
		// print sum of column 3
		System.out.println(result[4][3] - result[4][2]);
		// print sum of row 3
		System.out.println(result[3][4] - result[2][4]);
	}

	public int[][] calculateSum(int[][] input) {
		int[][] arr = new int[input.length + 1][input.length + 1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (j == 0 || i == 0) {
					arr[i][j] = 0;
					continue;
				}

				arr[i][j] = arr[i][j - 1] + arr[i - 1][j] + input[i - 1][j - 1] - arr[i - 1][j - 1];
			}
		}
		return arr;
	}

}
