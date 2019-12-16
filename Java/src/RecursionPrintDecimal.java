public class RecursionPrintDecimal {

	private void printDeciaml(int digits) {
		printDeciamlHelper(digits, "");
	}

	private void printDeciamlHelper(int digits, String string) {
		if (digits == 0) {
			System.out.print(string + "\n");
		} else {
			for (int x = 0; x <= 9; x++) {
				printDeciamlHelper(digits - 1, string + String.valueOf(x));
			}
		}
	}

	public static void main(String[] args) {
		RecursionPrintDecimal rec = new RecursionPrintDecimal();
		rec.printDeciaml(3);
	}
}
