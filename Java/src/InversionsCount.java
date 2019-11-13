//https://www.geeksforgeeks.org/counting-inversions/
//https://www.geeksforgeeks.org/count-inversions-of-size-k-in-a-given-array/
//https://www.geeksforgeeks.org/count-inversions-array-set-3-using-bit/
public class InversionsCount{
public static void main(String[] args) {
		int[] a = new int[] {1, 2, 3,0,0};
		count(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

	private static void count(int[] a) {
	
		sort(a);
		
	}
	static int count =0;
	private static void sort(int[] a) {
		int[] aux = new int[a.length];
		mSort(a, aux, 0, a.length-1);
		System.out.println(count + "  count ");
	}
	private static int mSort(int[] a, int[] aux, int lo, int hi) {
		
		if(lo>=hi) {
			return 0;
		}
		int m = (lo + hi)/2;
		count += mSort(a, aux, lo, m);
		count += mSort(a, aux, m+1, hi);
	    merge(a, aux, lo, m+1, hi);
		return mSort(a, aux, lo, m) +  mSort(a, aux, m+1, hi) +   merge(a, aux, lo, m+1, hi);
	}
	
	private static int merge(int[] a, int[] aux, int lo, int mid,  int hi) {
		int value = 0;
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
				value++;
			}
		}
		return value;
	}
}
