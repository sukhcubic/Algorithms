
public class ThreeSum {

	private static String sumOfThreeNumbers(int[] list, int desired) {
		// For array which is already sorted
		int x = 0;
		int y = 0;

		for (int i = 0; i < list.length - 2; i++) {
			x = i + 1;
			y = list.length - 1;
			System.out.println(x + "x");
			while (x < y) {
				System.out.println(y + "y");
				if (i + list[x] + list[y] == desired) {
					return "found ";
				} else if (i + list[x] + list[y] < desired) {
					x++;
				} else {
					y--;
				}
			}
		}

		return "Not Found";
	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 4, 5, 6, 7, 8, 9 };
		int desiredSum = 20;
		System.out.println(sumOfThreeNumbers(a, desiredSum));
	}

}
