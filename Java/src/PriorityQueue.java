//Source https://github.com/williamfiset/data-structures/blob/master/com/williamfiset/datastructures/priorityqueue/BinaryHeap.java
//https://github.com/bephrem1/backtobackswe/blob/master/Sorting%2C%20Searching%2C%20%26%20Heaps/ImplementABinaryHeap/ImplementABinaryHeap.java
//https://www.youtube.com/watch?v=t0Cq6tVNRBA&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=10
//https://www.coursera.org/learn/algorithms-part1/lecture/Uzwy6/binary-heaps
//https://www.youtube.com/watch?v=wptevk0bshY&t=13s
public class PriorityQueue {
	
	static int[] a = new int[9];
	static int lastIndex = 0;
	
	public static void insert(int element) {
		a[lastIndex] =  element;
		swim(lastIndex);

	}
	
	public static void delete() {
		System.out.println(" delete last index   "+lastIndex);
		a[0] =  a[lastIndex-1];	
		sink(0);
		for (int i = 0; i < lastIndex; i++) {
			System.out.println(a[i]);
		}
	}
	
// 	private static void swim(int x) {
// 		while(x > 0 && a[x] > a[(x-1)/2]) {
// 			swap((x-1)/2, x);
// 			x = (x-1)/2;
//  		}
// 		lastIndex++;
// 		for (int i = 0; i < lastIndex; i++) {
// 			System.out.println(" ss s s ss s s   "+a[i]);
// 		}
// 	}
	
	//Swim Test Max PQ
	private static void swim(int index){
	   // index-1/2 because 0 based index
		while(index >= 0 || a[index] < a[(index-1)/2]){
		    swap((index-1)/2, index);
		    index = (index-1)/2;	
		}
	       //increment index for next element to be added
		lastIndex++;
	}
	
	
	
	
	private static void sink(int x) {

		while(x < lastIndex) {
			System.out.println("dccc"+lastIndex  + "  xxx  "  + x);

			int left = 2*x+1;
			int right = 2*x+2;
			int selected = left;
			if(right< a.length && a[left]<a[right]) {
				selected = right;
			}
			
			if(left < lastIndex && a[left]> a[x]) {
				swap(x, selected);
				x = selected;
			}else {
				break;
			}
		}
		lastIndex--;
		System.out.println("dddd");

	}
	
	private static void delete(int num) {
		int foundIndex = -1;
		for(int i = 0; i<lastIndex; i++) {
			if(a[i]== num) {
				foundIndex = i;
				break;
			}
		}
		a[foundIndex] = a[lastIndex-1];
		sink(foundIndex);
		
		for (int i = 0; i < lastIndex; i++) {
			System.out.println(a[i]);
		}
	}
	
	private static void swap(int i, int j){
		int swap = a[i]; 
		a[i] = a[j];
		a[j] = swap; 
	  }

	
	public static void main(String[] args) {
		int[] a = new int[] { 77, 10, 9, 4, 78, 95, 15, 15,  3};
		for (int i : a) {
			System.out.println("  insert   " + i);
			insert(i);
		}
		delete();
		delete();
	}
}


