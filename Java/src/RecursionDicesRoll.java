import java.util.ArrayList;

public class RecursionDicesRoll {

	// https://www.bilibili.com/video/av21619854?p=11 starting around 17:00
	private void rollDicesHelper(int num, ArrayList<Integer> s) {
		if (num == 0) {
			System.out.print(s + "\n");
		} else {
			for (int i = 1; i <= 6; i++) {
				s.add(i);
				rollDicesHelper(num - 1, s);
				s.remove(s.size() - 1);
			}
		}
	}

	private void rollDices(int numberOfDices) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		rollDicesHelper(numberOfDices, list);
	}

	public static void main(String[] args) {
		RecursionDicesRoll rec = new RecursionDicesRoll();
		rec.rollDices(3);
	}
}
