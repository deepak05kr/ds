package algo_part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountingVowelSubsequence {
	public static void main(String args[]) throws Exception {

		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine(); // Reading input from STDIN
		input = input.toLowerCase();
		List<String> vowels = new ArrayList<>();
		populateVowels(vowels);
		int count = 0;
		List<String> inputStrings = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			if (vowels.contains(String.valueOf(input.charAt(i)))) {
				count++;
				input = input.toLowerCase();
				String str = input.substring(i, input.length()).replace("a", "").replace("e", "").replace("i", "")
						.replace("o", "").replace("u", "");
				count = count + getCount(str.length());

			}
		}

		System.out.println(count);
		// Write your code here

	}

	public static int getCount(int n) {
		return n * (n + 1) / 2;
	}

	private static void populateVowels(List<String> vowels) {
		vowels.add("a");
		vowels.add("e");
		vowels.add("i");
		vowels.add("o");
		vowels.add("u");

	}

}
