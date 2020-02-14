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
		// this is helpful when k is greater than size of array i.e. if lenght is 10 and k is 12 then %k will return 2 
		// we do not have to rotate array multiple time when k is greater than length of array
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
	
       private static int[] rotate2( int[] nums, int k) {	
		reverse2(nums, 0, nums.length-1);
		reverse2(nums, 0, k-1);
		reverse2(nums, k, nums.length-1);
		return nums;
	}

	
    private static void reverse2(int[] num, int start, int end ) {
	// we do not have to rotate array multiple time when k is greater than length of array. To avoid out of bound num.length/k remainder. 
	// if lenght is 10 and k is 12 then %k will return 2     
	k %= nums.length;
    	while(start < end) {
    		int temp = num[start];
    		num[start++] = num[end];
    		num[end--] = temp;
    	}    	
    }

    public static void main(String[] args) {
		int[] a = new int[] {1,2,3,4,5,6,7,8,9,10};
		for (int i : rotate(a, 8)) {
			System.out.println(i);
		}
	}
}
