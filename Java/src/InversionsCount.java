//https://www.geeksforgeeks.org/counting-inversions/
//https://www.geeksforgeeks.org/count-inversions-of-size-k-in-a-given-array/
//https://www.geeksforgeeks.org/count-inversions-array-set-3-using-bit/
public class InversionsCount{

	public static void main(String[] args) {
		int[] a = new int[] {1, 20, 6, 4, 5};
		count(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

	private static void count(int[] a) {
		sort(a);	
	}
	
	private static void sort(int[] a) {
		int[] aux = new int[a.length];
		System.out.println(mSort(a, aux, 0, a.length-1) + "  count ");
	}
	
	private static int mSort(int[] a, int[] aux, int lo, int hi) {
		if(lo>=hi) {
			return 0;
		}
		int m = lo + (hi - lo) / 2;
		
		return mSort(a, aux, lo, m) +  mSort(a, aux, m+1, hi) +   merge(a, aux, lo, m, hi);
	}
	
	private static int merge(int[] a, int[] aux, int lo, int mid,  int hi) {
		int value = 0;
		
		for (int i= 0; i<=hi; i++ ) {
			aux[i] = a[i];
		}
		
		int m = mid+1;
		int l = lo;
		int i = lo;
		
		while(l <=  mid && m <= hi ) {
			if(aux[l] < aux[m] ) {
				a[i++] = aux[l++];
				value += mid+1-l; 
			}else {
				a[i++] = aux[m++];
			}
		}
		
		while(m <= hi) {
			a[i++] = aux[m++];
			value++;
		}
		
		while(l <= mid) {
			a[i++] = aux[l++];	
		}
		
//		for(int i = lo; i <= hi; i++) {
//			if(l > mid) {
//				// first half exhausted but we still have some elements left on second half. Copy them over
//				a[i] = aux[m++];
//			}else if(m > hi) {
//				// Second half exhausted but we still have some elements left on first half. Copy them over
//				a[i] = aux[l++];
//			}else if(aux[l] > aux[m] ) {
//				a[i] = aux[m++];
//				if(m > l) {
//				value++;
//				}
//			}else {
//				a[i] = aux[l++];
//				if(l > m) {
//				value++;
//				}
//			}
//		}
		
		return value;
	}
}
