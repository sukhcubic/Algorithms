import java.util.ArrayList;

//https://www.bilibili.com/video/av21619854?p=11 at 46:00
public class RecursionSuperSet {
	// in this algorith we need to deicede if we need to include in decision treee or not.
	private void subsetHelper(ArrayList<String> s, ArrayList<String> chosen) {
		if(s.size() == 0) {
			System.out.print(s);
		}else {

		  //select one from list
		  String nm = s.get(0);
		
		  //remove from list
		  s.remove(0);
		
		  //Include in decision tree
		  chosen.add(nm);
		  subsetHelper(s, chosen);
		
		  //Exclude chosen 
		
		  chosen.remove(chosen.size() -1);
		  subsetHelper(s, chosen);
		}
		
	}
	
	private void subset(ArrayList<String> names) {
		ArrayList<String> s = new ArrayList<String>();
		subsetHelper(names, s);
	}
	
	

	public static void main(String[] args) {
		RecursionSuperSet rec = new RecursionSuperSet();
		ArrayList<String> names = new ArrayList<String>();
		names.add("BOB");
		names.add("DOB");
		names.add("SAM");
		names.add("RAM");
		rec.subset(names);
	}

}
