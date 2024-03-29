
import java.util.ArrayList;

//https://www.bilibili.com/video/av21619854?p=11 at 46:00
public class RecursionSuperSet {
	// in this algorithm we need to decide if we need to include in decision tree
	// or not.
	private void subsetHelper(ArrayList<String> s, ArrayList<String> chosen) {
		// System.out.print(s.size());

		if (s.size() == 0) {
			System.out.print(chosen + "\n");
		} else {
			// select one from list
			String nm = s.get(0);

			// choose from list
			s.remove(0);

			// Include in decision tree
			chosen.add(nm);
			subsetHelper(s, chosen);

			// Exclude chosen

			chosen.remove(chosen.size() - 1);
			subsetHelper(s, chosen);

			// unchoose
			s.add(0, nm);
		} 
	}

	private void subset(ArrayList<String> names) {
		ArrayList<String> s = new ArrayList<String>();
		subsetHelper(names, s);
	}

	public static void main(String[] args) {
		RecursionSuperSet rec = new RecursionSuperSet();
		ArrayList<String> names = new ArrayList<String>();
		names.add("B");
		names.add("D");
		names.add("S");
		rec.subset(names);
	}
	//https://www.youtube.com/watch?v=bGC2fNALbNU
	//https://www.youtube.com/watch?v=RnlHPR0lyOE
	//https://github.com/williamfiset/Algorithms/blob/master/com/williamfiset/algorithms/other/PowerSet.java
	private void subsetHelper(String s, int index, String chosen) {
		// System.out.print(s.size());
		int n = s.length();

		if (index == n) {
			System.out.print(chosen + "\n");
		} else {
			subsetHelper(s, index + 1, chosen + s.charAt(index));
			subsetHelper(s, index + 1, chosen);
		}
	}

	private void subset(String names) {
		subsetHelper(names, 0, "");
	}


}
