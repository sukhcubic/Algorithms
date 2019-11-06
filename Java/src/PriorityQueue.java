
public class PriorityQueue {
	
	static int[] a = new int[20];
	static int lastIndex = 0;
	
	public static void insert(int element) {
		a[lastIndex] =  element;
		swim(lastIndex);
		lastIndex++;
	}
	
	public static void delete() {
		a[0] =  a[lastIndex--];	
		sink(0);
	}
	
	private static void swim(int x) {
		while(x >0 && a[ x] > a[x/2]) {
			swap(x, x/2);
			x = x/2;
 		}
	}
	
	private static void sink(int x) {
		while(x < lastIndex) {
			int left = 2*x+1;
			int right = 2*x+2;
			int selected = left;
			if(right< a.length && left>right) {
				selected = right;
			}
			
			if(x > selected) {
				break;
			}
			
			swap(x, selected);
			
			x = selected;
		}
	}
	
	private static void swap(int i, int j){
		int swap = a[i]; 
		a[i] = a[j];
		a[j] = swap; 
	  }
	
	
	public static void main(String[] args) {
		int[] a = new int[] { 77, 10, 9, 4, 78, 95, 15, 15,  3};
	//	sort(a, 0, a.length-1);
		for (int i : a) {
			insert(i);
		}
		
		for (int i : a) {
			System.out.println(i);
		}
	}

}
