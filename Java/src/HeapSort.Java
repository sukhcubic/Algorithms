

public class HeapSort {
//https://www.youtube.com/watch?v=B7hVxCmfPtM&t=702s

static int[] a = new int[] { 77, 10, 9, 4, 78, 95, 15, 100, 34, 56, 770, 969};
static int L = a.length;
// Heapyfy or MaxHeap
//https://www.youtube.com/watch?v=HqPJF2L5h9U 41:37
//The idea is start from last subtree and heapyfy or maxheap (last parent would be L/2 -1, will give ust last parent) and sink it
private static void maxHeap() {
	int s = L/2 -1;
	for(int i = s; i >= 0; i--) {
		System.out.print(" maxHeapSink = " + i + " s "+ s + "\n");
		sink(i);
	}
}

private static void minHeap() {
	
}

private static void sort() {

	maxHeap();
	while (L > 0) {
	int temp = a[0];
	 a[0] = a[L-1];
	 a[L-1] = temp;
	 --L;
	 sink(0);
	}
	

}

private static void swim(int x) {
	while(x > 0 && a[x] > a[(x-1)/2]) {
		swap((x-1)/2, x);
		x = (x-1)/2;
		}
//	for (int i = 0; i < L; i++) {
//		System.out.println(" ss s s ss s s   "+a[i]);
//	}
}

	
	// refer to priority queue sink for possible exception
private static void sink(int x) {

	while(x <= L) {
		int left = 2*x+1;
		int right = 2*x+2;
		int selected = left;
		if(right < L && a[selected]<a[right]) {
			selected = right;
		}
		
		if(selected < L && a[selected]> a[x]) {
			swap(x, selected);
			x = selected;
		}else {
			break;
		}
	}
	
//	for (int i = 0; i < a.length; i++) {
//	System.out.println(" ss s s ss s s  L " + L  +"  "+a[i]);
//     }

}

private static void swap(int i, int j){
	int swap = a[i]; 
	a[i] = a[j];
	a[j] = swap; 
  }


public static void main(String[] args) {
	sort();
	
	for (int i : a) {
		System.out.println( i);
	}
}
}
