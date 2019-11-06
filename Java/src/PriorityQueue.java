//Source https://github.com/williamfiset/data-structures/blob/master/com/williamfiset/datastructures/priorityqueue/BinaryHeap.java
//https://github.com/bephrem1/backtobackswe/blob/master/Sorting%2C%20Searching%2C%20%26%20Heaps/ImplementABinaryHeap/ImplementABinaryHeap.java
//https://www.youtube.com/watch?v=t0Cq6tVNRBA&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=10
//https://www.coursera.org/learn/algorithms-part1/lecture/Uzwy6/binary-heaps
public class PriorityQueue {
	
	static int[] a = new int[9];
	static int lastIndex = 0;
	
	public static void insert(int element) {
		a[lastIndex] =  element;
		swim(lastIndex);
		lastIndex++;
	}
	
	public static void delete() {
		a[0] =  a[lastIndex-1];	
		sink(0);
		lastIndex--;
	}
	
	private static void swim(int x) {
		int parent = (x-1)/2;
		System.out.println("sss");

		while(x >0 && a[x] < a[parent]) {

			swap(parent, x);
			x = parent;
			parent = (x-1)/2;
 		}
		
		for (int i : a) {
			System.out.println(i);
		}
	}
	
	private static void sink(int x) {

		while(x < lastIndex) {
			System.out.println("dccc"+lastIndex  + "  xxx  "  + x);

			int left = 2*x+1;
			int right = 2*x+2;
			int selected = left;
			if(right< a.length && left>right) {
				selected = right;
			}
			
			if(left >= a.length|| left < x) {
				break;
			}
			swap(x, selected);
			
			x = selected;

		}
		System.out.println("dddd");
		for (int i : a) {
			System.out.println(i);
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
		delete();
	}

}


