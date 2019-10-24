
import java.util.Random;

public class Shuffle {

	
	
	public static int[] shuffle(int [] a) {
		Random rand = new Random(); 

		
		for(int i = 1; i < a.length; i++) {
			int random = rand.nextInt(i);
			int swap = a[i];
			a[i] = a[random];
			a[random] = swap;
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i : shuffle(a)) {
			System.out.println(i);
		}
	}
}
