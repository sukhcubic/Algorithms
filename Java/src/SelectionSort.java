public class InsertionSort {

	public static int[] insertionSort(int[] data) {

		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] >= data[j]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		return data;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 4, 2, 1, 1, 7, 4, 5, 6, 6, 6, 7, 7, 5, 9, 7 };
		for (int i : insertionSort(a)) {
			System.out.println(i);
		}
	}
}
