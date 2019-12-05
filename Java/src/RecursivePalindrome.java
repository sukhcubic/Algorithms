
public class RecursivePalindrome {

	private boolean isPalindrome(String s) {
		 if(s.length() <= 1) {
			 return true;
		 }else {
			
			 if(s.charAt(0) == s.charAt(s.length()-1)) {
				 return isPalindrome(s.substring(1, s.length()-1));
			 }else {
				 return false;
			 }
		 }
	
	}
	
	public static void main(String[] args) {
		RecursivePalindrome rec = new RecursivePalindrome();
		//System.out.println(rec.isPalindrome("abcba"));
		System.out.println(rec.isPalindrome("abccba"));

	}
}
