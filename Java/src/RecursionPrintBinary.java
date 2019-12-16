public class RecursionPrintBinary {

	private void printBinary(int digits) {
		printBinaryHelper(digits, "");			
	}
	

	private void printBinaryHelper(int digits, String string) {

		if(digits == 0) {
			System.out.print(string + "\n");
		}
		else {
			//			  0               1
                        //			/   \            /  \
                        //		       00     01        10    11
                        //		      /  \   /  \      /  \   / \
                        //	            000 001 010 011  100 101 110 111 
			printBinaryHelper(digits -1, string + "0");
			printBinaryHelper(digits -1, string + "1");
		}
	}


	public static void main(String[] args) {
		RecursionPrintBinary rec = new RecursionPrintBinary();
	    rec.printBinary(10);
	}
}
