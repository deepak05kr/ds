package array;

public class SearchingElement {

	public int LinearSearch(int[] inputArr, int elementToSearch) {

		for (int i = 0; i < inputArr.length; i++) {
			if (inputArr[i] == elementToSearch) {
				return i;
			}
		}
		return -1;
	}

	public int BinarySearch(int[] inputArr, int elementToSearch, int start, int end) {

		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (inputArr[mid] == elementToSearch) {
			return mid;
		}
		if (inputArr[mid] > elementToSearch) {
			return BinarySearch(inputArr, elementToSearch, mid + 1, end);
		} else {
			return BinarySearch(inputArr, elementToSearch, start, mid - 1);
		}

	}

	public int TernarySearch() {
		return -1;
	}
}
