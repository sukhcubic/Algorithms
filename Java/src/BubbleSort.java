public class BubbleSort {
	public static void main(String[] args) {
		int[] a = new int[] {10, 7, 12, 8, 3, 2, 1, 11, 11};
		sort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

	private static void sort(int[] a) {
// Shrink array since last one is already sorted
		for(int i = a.length-1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(a[j] > a[j+1]) {
					swap(a,j , j+1);
				}
			}
		}
	}
	private static void swap(int[] a, int x, int y){
		int swap = a[x]; 
		a[x] = a[y];
		a[y] = swap; 
	  }
	
}
