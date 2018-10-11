package algo_part1;

public class BitonicSearch {
	public int searchInAscendingArr(int[] inputArr, int start, int end, int value) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (inputArr[mid] == value) {
			return mid;
		} else if (inputArr[mid] > value) {
			return searchInAscendingArr(inputArr, start, mid - 1, value);
		} else {
			return searchInAscendingArr(inputArr, mid + 1, end, value);
		}
	}

	public int searchInDescendingArr(int[] inputArr, int start, int end, int value) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (inputArr[mid] == value) {
			return mid;
		} else if (inputArr[mid] > value) {
			return searchInDescendingArr(inputArr, mid + 1, end, value);
		} else {
			return searchInDescendingArr(inputArr, start, mid - 1, value);
		}
	}

	public int getMaxValueIndex(int[] inputArr, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (inputArr[mid] > inputArr[mid - 1]) {
			if (inputArr[mid] > inputArr[mid + 1]) {
				return mid;
			} else {
				return getMaxValueIndex(inputArr, mid, end);
			}
		} else {
			return getMaxValueIndex(inputArr, start, mid);
		}
	}

	public static void main(String args[]) {

		int arr1[] = { -3, 6, 8, 20, 17, 5, 1 };
		int arr2[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };

		BitonicSearch bs = new BitonicSearch();

		int maxValueIndex_Arr1 = bs.getMaxValueIndex(arr1, 0, arr1.length);
		int index = bs.searchInAscendingArr(arr1, 0, maxValueIndex_Arr1, 5);
		if (index == -1)
			index = bs.searchInDescendingArr(arr1, maxValueIndex_Arr1, arr1.length - 1, 5);
		System.out.println("found value at index " + index);

		int maxValueIndex_Arr2 = bs.getMaxValueIndex(arr2, 0, arr2.length);
		index = bs.searchInAscendingArr(arr2, 0, maxValueIndex_Arr2, 5);
		if (index == -1)
			index = bs.searchInDescendingArr(arr2, maxValueIndex_Arr2, arr1.length - 1, 5);
		System.out.println("found value at index " + index);

	}
}
