//Mentioned at https://www.ideserve.co.in/learn/maximum-element-from-each-subarray-of-size-k-set-2
public class MaxElementOfEachSubarray {
	
	public static void main(String[] args) {
		int[] a = new int[] {9,6,11,8,10,5,14,13,93,14};
		System.out.println(find(a, 4));
	
	}

	private static String find(int[] a, int subArraySize) {
		String s = "";
		int max = a[0];
		for(int i = 0; i<a.length; i++) {
	
			if(i<subArraySize) {
				// we already set max at a[0]. At first iteration value will be equal.
				if(a[i] > max) {
					max = a[i];
				}
				if(i == 3) {
				  s += Integer.toString(max) + " ";	
				}
			}else {
				if(a[i] > max) {
					max = a[i];
					 s += Integer.toString(max) + " ";	
				}else {
					 s += Integer.toString(max) + " ";	
				}
			}
		}
		return s;
	}
}
