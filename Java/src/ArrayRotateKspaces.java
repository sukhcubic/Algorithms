public class ArrayRotateKspaces {
//Given an array and an integer k, rotate the array by k spaces. Do this without generating a new array and without using extra space.
//[1, 2, 3, 4, 5] to [3, 4, 5, 1, 2]
	
	// Slow
//	private static int[] rotate( int[] a, int position) {
//		// brute force
//		for(int i =0; i < position; i++) {
//		
//			int val = a[0];
//			
//			for(int z =0; z < a.length - 1; z++) {
//				a[z] =  a[z +1];
//			}
//			a[a.length-1] = val;
//		}
//		return a;
//	}
	
	//fast
	private static int[] rotate( int[] nums, int k) {

//		position = a.length-1 - position;
//		reverse(a, 0, a.length-1);
//		reverse(a, 0, position-1);
//		reverse(a, position, a.length-1);
	    k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
		
		return nums;
	}

	private static void reverse(int [] a, int start, int end) {
		while(start < end) {
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start ++;
			end --;
		}
	}
	public static void main(String[] args) {
		int[] a = new int[] {1,2,3,4,5,6,7,8,9,10};
		for (int i : rotate(a, 8)) {
			System.out.println(i);
		}
	}
}
