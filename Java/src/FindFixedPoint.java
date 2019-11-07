//A fixed point in a list is where the value is equal to its index. So for example the list [-5, 1, 3, 4], 1 is a fixed point
//in the list since the index and value is the same. Find a fixed point (there can be many, just return 1) in a sorted list 
//of distinct elements, or return None if it doesn't exist.

public class FindFixedPoint {
// Fast way is using Binary search which takes log(n) time complexity
	public static int find(int[] values) {
		return find(values, 0, values.length-1);
	}
	
	public static int find(int[] values, int start, int end) {
		int found = -1;
		if(end>=start) {
	    int mid = (start+end)/2;
	    //Check where matching index lies in the sorted array
	    if(mid == values[mid]) {
	    	return mid;
	    }else if(mid > values[mid]){
	    	return find(values, mid +1, end );
	    }else {
	    	return find(values, start,  mid-1);
	    }
		}
		return found;
	}
	

	public static void main(String[] args) {
		int[] a = new int[] {-10, -1, 0, 3 , 10, 11, 30, 50, 100};

		System.out.print(find(a));
	}
	
}
