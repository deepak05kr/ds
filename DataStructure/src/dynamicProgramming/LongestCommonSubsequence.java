package dynamicProgramming;

public class LongestCommonSubsequence {

	public static void main(String args[]) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String input = "abcdaf";
		String match = "acbcf";
		int maxSubsequenceLength = lcs.getLongestCommonSubsequenceLength(input.toCharArray(), match.toCharArray());
		System.out.println(maxSubsequenceLength);
	}

	public int getLongestCommonSubsequenceLength(char[] input, char[] match) {
		int[][] arr = new int[match.length + 1][input.length + 1];
		for (int i = 0; i <= match.length; i++) {
			for (int j = 0; j <= input.length; j++) {
				if (i == 0 || j == 0) {
					arr[i][j] = 0;
					continue;
				}
				if (match[i - 1] == input[j - 1]) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
				}
			}
		}
		return arr[match.length][input.length];
	}
}
