package algo_part1;

public class MergeSort {

	public void sort(Integer[] arr) {
		Integer[] aux = new Integer[arr.length];
		sort(arr, aux, 0, arr.length - 1);
	}

	private void sort(Integer[] arr, Integer[] aux, int low, int high) {
		if (high <= low) {
			return;
		}
		int mid = low + (high - low) / 2;
		sort(arr, aux, low, mid);
		sort(arr, aux, mid + 1, high);
		merge(arr, aux, low, high, mid);

	}

	private void merge(Integer[] arr, Integer[] aux, int low, int high, int mid) {
		if (high < low) {
			return;
		}
		for (int i = low; i <= high; i++) {
			aux[i] = arr[i];
		}
		int i = low;
		int j = mid + 1;
		for (int k = low; k <= high; k++) {
			if (i > mid) {
				arr[k] = aux[j];
				j++;
			} else if (j > high) {
				arr[k] = aux[i];
				i++;
			} else if (aux[i] < aux[j]) {
				arr[k] = aux[i];
				i++;
			} else {
				arr[k] = aux[j];
				j++;
			}
		}
	}

	public void printArr(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String args[]) {
		Integer[] arr = { 4, 6, 13, 7, 23, 5, 2, 1 };
		MergeSort ms = new MergeSort();
		ms.sort(arr);
		ms.printArr(arr);

	}
}
