
public class MergeSort {

	// Refer https://www.coursera.org/learn/algorithms-part1/lecture/ARWDq/mergesort
	// for details and techniques to improve performance
	
	private static int[] sort(int[] a) {
      sort(a, new int[a.length], 0, a.length-1);
      return a;
	}

	private static void sort(int[] a, int aux[], int lo, int hi) {

//		if(hi <= lo) {
//		 return;	
//		}
		if(lo < hi) {
		  int mid = (lo+hi)/2;
	      sort(a,aux, lo, mid);
	  	  sort(a,aux, mid+1, hi);
		  merge(a,aux, lo, mid, hi);
		}
	}
	
	private static void merge(int[] a, int aux[], int lo, int mid, int hi) {

		int low = lo;
		int middle = mid+1;

		// Copy elements
		for(int i = lo; i<=hi; i++ ) {
			aux[i] = a[i];
		}
      
		for(int i = lo; i<=hi; i++) {
			if(low>mid) {
				// Left half is exhausted copy remaining Right half
				a[i] = aux[middle++];
			}else if(middle > hi) {
				// Right half is exhausted copy remaining Left half
				a[i] = aux[low++];
			}else if(aux[middle] < aux[low]) {
				a[i] = aux[middle++];
			}else {
				a[i] = aux[low++];
			}
		}
	// Also see inversion count algorithm	
// 		while(l <=  mid && m <= hi ) {
// 			if(aux[l] > aux[m] ) {
// 				a[i] = aux[m++];
// 			}else {
// 				a[i] = aux[l++];
// 			}
// 			i++;
// 		}
		
// 		while(m <= hi) {
// 			a[i++] = aux[m++];
			
// 		}
// 		while(l <= mid) {
// 			a[i++] = aux[l++];	
// 		}
	}
	
	
	
	static  int[] mergeSort(int[] elements){

        if(elements.length <= 1){
           return elements;
        }

        int pivot = elements.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(elements, 0, pivot));
        int[] right = mergeSort(Arrays.copyOfRange(elements, pivot, elements.length));
        return mergeHelper(left, right);
    }

    static int[] mergeHelper(int[]a, int [] b){
        int[] result = new int[a.length+b.length];
        int i = 0, j = 0, res = 0;
        while(i<a.length &&j<b.length){
            if(a[i] > b[j]){
                result[res++] = b[j++];
            }else{
                result[res++] = a[i++];
            }
        }


        while (i<a.length){
            result[res++] = a[i++];
        }

        while (j<b.length){
            result[res++] = b[j++];
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] a = new int[] {10, 7, 12, 8, 3, 2, 1, 11, 11};
		sort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}
}
