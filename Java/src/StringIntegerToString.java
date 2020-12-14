public class StringIntegerToString {
	
	
	static String convert(int s){
		StringBuilder sb = new StringBuilder();
		while(s>1){
			int x = s%10;
			//System.out.print("ss = "+ s);
			char ss = (char) ('0'+x);
			sb.append(ss);	
			s = s/10;
		}

		return sb.reverse().toString();
				
	}
	
	public static void main(String arg[]){
		System.out.print(convert(21));
	}

}
