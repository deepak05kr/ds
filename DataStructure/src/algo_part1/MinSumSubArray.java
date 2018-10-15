package algo_part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class MinSumSubArray {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine(); // Reading input

		String[] inputStringArr = line.split("\\s+");
		int size = Integer.parseInt(inputStringArr[0]);
		int[] inputArr = new int[size];
		line = br.readLine();
		inputStringArr = line.split("\\s+");
		for (int i = 0; i < size; i++) {
			inputArr[i] = Integer.parseInt(inputStringArr[i]);
		}

		// Write your code here
		long sum = getMinSum(inputArr);
		System.out.println(sum);
	}

	public static long getMinSum(int[] inputArr) {
		int arrSize = inputArr.length;
		int windowSize = arrSize / 2;
		long total = 0;
		for (int i = 0; i < windowSize; i++) {
			total = total + inputArr[i];
		}
		long sum = total;
		int[] auxArr = new int[arrSize + windowSize];
		for (int i = 0; i < arrSize; i++) {
			auxArr[i] = inputArr[i];
		}
		for (int i = arrSize; i < arrSize + windowSize; i++) {
			auxArr[i] = inputArr[i - arrSize];
		}
		for (int i = windowSize; i < arrSize + windowSize; i++) {
			sum = sum + auxArr[i] - auxArr[i - windowSize];
			if (total > sum) {
				total = sum;
			}
		}
		return total;
	}
}
