public class InversionsCount{
	public static void main(String[] args) {
		int[] a = new int[] {10, 7, 12, 8, 3, 2};
		count(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

	private static void count(int[] a) {
		int mid = a.length/2;
		int secondHalf = a.length - mid;
		int[] aux1 = new int[mid];
		int[] aux2 = new int[secondHalf];		

		for (int i= 0; i<a.length; i++ ) {
			int z = 0;
			if(i<mid) {
				aux1[i] = a[i];
			}else {
				aux2[z++] = a[i];
			}
		}
		mSort(a, aux1, 0, mid);
		mSort(a, aux2, mid+1, a.length-1);
		
	}
	
	private static void sort(int[] a) {
		int[] aux = new int[a.length];
		mSort(a, aux, 0, a.length-1);
	}
	
	private static void mSort(int[] a, int[] aux, int lo, int hi) {
		if(lo>= hi) {
			return;
		}
		int m = (lo + hi)/2;
		mSort(a, aux, lo, m);
		mSort(a, aux, m+1, hi);
		merge(a, aux, lo, m+1, hi);
		
	}
	
	private static void merge(int[] a, int[] aux, int lo, int mid,  int hi) {
		for (int i= 0; i<a.length; i++ ) {
			aux[i] = a[i];
		}
		int m = mid;
		int l = lo;
		for(int i = lo; i<= hi; i++) {
			if(l > mid) {
				// first half exhausted but we still have some elements left on second half. Copy them over
				a[i] = aux[m++];
			}else if(m > hi) {
				// Second half exhausted but we still have some elements left on first half. Copy them over
				a[i] = aux[l++];
			}else if(aux[l] < aux[m] ) {
				a[i] = aux[l++];
			}else {
				a[i] = aux[m++];
			}
		}
	}
}
