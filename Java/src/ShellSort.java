public class ShellSort {

	public static int[] shellSort(int[] numbers) {
		// System.out.println("bbbb1b");
		int N = numbers.length;
		int j;
		int gap = 1;
		// while (gap < N / 3)
		// gap = 3 * gap + 1; // 1, 4, 13, 40, 121, 364, ...
		// while (gap >= 1) {
		//
		// for (int i = gap; i < numbers.length; i++) {
		// int temp = numbers[i];
		// // holding temp value
		// for (j = i; j >= gap && numbers[j - gap] > temp; j -= gap) {
		// // shifting value based on size. For example, we have gap of
		// // 3 and at index 12 we have 13 which is temp
		// // value and at index 9 which is j-gap we have 14 this will
		// // assign 14 at index 12 which is j and outside
		// // for loop, we have updated index 9 (j -=gap) will be
		// // assigned with 13 th temp value. This is how exchange
		// // of value is happening.
		// numbers[j] = numbers[j - gap];
		// }
		// // assigning temp value
		// numbers[j] = temp;
		// }
		// gap = gap / 3;
		// }
		// or

		while (gap < N / 3)
			gap = 3 * gap + 1; // 1, 4, 13, 40, 121, 364, ...
		while (gap >= 1) {
			for (int i = gap; i < numbers.length; i++) {
			// validate if  numbers[j - gap] > numbers[j] then swap
				for (j = i; j >= gap && numbers[j - gap] > numbers[j]; j -= gap) {
					int swap = numbers[j]; 
					numbers[j] = numbers[j - gap];
					numbers[j-gap] = swap; 
				}
			}
			gap = gap / 3;
		}

		// for (int gap = numbers.length / 2; gap > 0; gap /= 2) {
		// // System.out.println(gap + "bbb2bb " + numbers.length);
		// for (int i = gap; i < numbers.length; i++) {
		// int temp = numbers[i];
		// for (j = i; j >= gap && numbers[j - gap] > temp; j -= gap) {
		// numbers[j] = numbers[j - gap];
		// }
		// numbers[j] = temp;
		// }
		// }

		return numbers;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 4, 2, 1, 7, 5, 3, 55, 67, 7, 8, 9, 4, 78, 95, 67, 3, 56, 86, 99, 37 };
		String s = "";
		for (int i : shellSort(a)) {
			System.out.println(i);

			// s += String.valueOf(i);
		}
		System.out.println(s);
	}
}
