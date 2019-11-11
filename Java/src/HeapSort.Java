
public class HeapSort {

		static int[] a = new int[] { 77, 10, 9, 4, 78, 95, 15};
	static int L = a.length;
	
	private static void maxHeap() {
		int s = L/2 -1;
		for(int i = s; i >= 0; i--) {
			System.out.print(" maxHeapSink = " + i + " s "+ s);
			sink(i);
		}
	}
	
	private static void minHeap() {
		
	}
	
	private static void sort() {
		maxHeap();

	}
	
	private static void swim(int x) {
		while(x > 0 && a[x] > a[(x-1)/2]) {
			swap((x-1)/2, x);
			x = (x-1)/2;
 		}
//		for (int i = 0; i < L; i++) {
//			System.out.println(" ss s s ss s s   "+a[i]);
//		}
	}
	
	private static void sink(int x) {

		while(x <= L) {
			int left = 2*x+1;
			int right = 2*x+2;
			int selected = left;
			if(right< a.length && a[left]<a[right]) {
				selected = right;
			}
			
			if(left < L && a[left]> a[x]) {
				swap(x, selected);
				x = selected;
			}else {
				break;
			}
		}

	}
	
	private static void swap(int i, int j){
		int swap = a[i]; 
		a[i] = a[j];
		a[j] = swap; 
	  }
	
	
	public static void main(String[] args) {
		sort();
		
		for (int i : a) {
			System.out.println("  insert   " + i);
		}
	}
}
