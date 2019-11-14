//https://www.youtube.com/watch?v=G8chEDeeKvY
//https://www.geeksforgeeks.org/counting-inversions/
//https://www.geeksforgeeks.org/count-inversions-of-size-k-in-a-given-array/
//https://www.geeksforgeeks.org/count-inversions-array-set-3-using-bit/
public class InversionsCount{
	public static void main(String[] args) {
		int[] a = new int[] {1, 20, 6, 4, 5};
		count(a);
//		for (int i : a) {
//			System.out.println(i);
//		}
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
		int m = (lo + hi) / 2;
		
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
			if(aux[l] > aux[m] ) {
				a[i++] = aux[m++];
				//https://github.com/guibin/Knowledge/blob/master/libs/lib.algorithm/src/main/java/guibin/zhang/onlinecourse/CountingInversions.java
	             //This is the most important part to count the inversions.
                //If aux[i] > aux[j], then following items in left part are all > aux[j].
                //So for aux[j], there are totally (mid - i + 1) reversed items: aux[i], aux[i + 1], ..., aux[mid] > aux[j],
                //since at this stage, sub-array [lo, mid], [mid + 1, hi] are sorted repectively.
				value += mid-l+1; // +1 because its zero based
			}else {
				a[i++] = aux[l++];
			}
		}
		
		while(m <= hi) {
			a[i++] = aux[m++];
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
