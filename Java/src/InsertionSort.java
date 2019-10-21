public class InsertionSort {

	public static int[] insertionSort(int[] data) {

		for (int i = 1; i < data.length; i++) {
			int temp = data[i];
			for (int j = i - 1; j >= 0; j--) {
				if (temp < data[j]) {
					int x = data[j];
					data[j] = temp;
					data[i] = x;
				} else {
					break;
				}
			}
		}
		return data;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 4, 2, 1, 1, 7, 4, 5, 6, 6, 6, 7, 7, 5, 9, 7 };
		// insertionSort(a);
		for (int i : insertionSort(a)) {
			System.out.println(i);
			System.out.println(i);

		}
	}
}
