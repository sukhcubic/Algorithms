
public class RecursionPermuteString {
	//https://www.bilibili.com/video/av21619854?p=10  starting at 30:00
	private void permuteHelper(String s, String pre) {
		if(s.length() == 0) {
			System.out.append(pre + "\n");
		}else {
			for(int i = 0; i <s.length(); i++) {
				//pick a string which is going to be prefix
				String sub = s.substring(i, i+1);
				
				// choose remaining string
				String ss = s.substring(0, i) + s.substring(i+1);
				permuteHelper(ss, pre+sub);
			}
		}
		
	}
	
	private void permute(String s) {
		permuteHelper(s, "");
	}
	
	

	public static void main(String[] args) {
		RecursionPermuteString rec = new RecursionPermuteString();
		rec.permute("SMARTY");
	}
}
