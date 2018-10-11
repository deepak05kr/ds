//The 3SUM problem asks if a given set of  n real numbers contains three elements that sum to zero
//3-SUM in quadratic time. Design an algorithm for the 3-SUM problem that takes time proportional to n^2
//  in the worst case. You may assume that you can sort the n integers in time proportional to n^2
//  or better.

package algo_part1;

public class _3SumProblem {
	public void print3lements(int[] sortedInput) {
		for (int i = 0; i <= sortedInput.length - 2; i++) {
			int a = sortedInput[i];
			int start = i + 1;
			int end = sortedInput.length - 1;
			while (start < end) {
				int b = sortedInput[start];
				int c = sortedInput[end];
				if (a + b + c == 0) {
					System.out.println(a + " " + b + " " + c);
					start = start + 1;
					end = end - 1;
				} else if (a + b + c > 0) {
					end = end - 1;

				} else {
					start = start + 1;
				}

			}
		}
	}

	public int countCombinations(int[] sortedInput) {
		int count = 0;
		for (int i = 0; i <= sortedInput.length - 2; i++) {
			int a = sortedInput[i];
			int start = i + 1;
			int end = sortedInput.length - 1;
			while (start < end) {
				int b = sortedInput[start];
				int c = sortedInput[end];
				if (a + b + c == 0) {
					count++;
					start = start + 1;
					end = end - 1;
				} else if (a + b + c > 0) {
					end = end - 1;

				} else {
					start = start + 1;
				}

			}
		}
		return count;
	}

	public static void main(String args[]) {
		int[] sortedInput = { -25, -10, -7, -3, 2, 4, 8, 10 };
		_3SumProblem obj = new _3SumProblem();
		obj.print3lements(sortedInput);
	}
}
