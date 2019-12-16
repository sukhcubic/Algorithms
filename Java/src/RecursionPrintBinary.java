public class RecursionPrintBinary {

	private void printBinary(int digits) {
		printBinaryHelper(digits, "");			
	}
	

	private void printBinaryHelper(int digits, String string) {

		if(digits == 0) {
			System.out.print(string + "\n");
		}
		else {
			printBinaryHelper(digits -1, string + "0");
			printBinaryHelper(digits -1, string + "1");
		}
	}


	public static void main(String[] args) {
		RecursionPrintBinary rec = new RecursionPrintBinary();
	    rec.printBinary(10);
	}
}
