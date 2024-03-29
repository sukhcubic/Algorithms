
//Dutch national flag. Given an array of nn buckets, each containing a red, white, or blue pebble, sort them by color. The allowed operations are:

//swap(i, j)swap(i,j): swap the pebble in bucket ii with the pebble in bucket jj.
//color(i)color(i): determine the color of the pebble in bucket ii.
//The performance requirements are as follows:

//At most nn calls to color()color().
//At most nn calls to swap()swap().
//Constant extra space.


public class DutchFlag {

	public static int[] sort (int [] array) {
		int low = 0, mid = 0, high = array.length -1;
		int num = 0;
		while(mid < high) {
//			num++;
//			if(array[mid] == 0) {
//				swap(array, low, mid);
//				low++;
//				mid++;
//
//			}
//			else if(array[mid] == 1) {
//				mid++;
//			}
//			else {
//				swap(array, high, mid);
//				high--;	
//			}
     
			if(array[mid] == 0) {
				swap(array, low, mid);
				low++;
				mid++;
			}
			if(array[mid] == 1) {
				mid++;
			}
			if(array[mid] == 2) {
				swap(array, mid, high);
				high--;
			}
	
		}
//	       for (int i = 0; i <= high; i++)
//           {
//               if (array[i] == 0)
//                   swap(array, low++, i--);
//
//               if (array[i] == 2)
//                   swap(array, i--, high--);
//           }
		
		System.out.println(num);

		return array;
	}
	
	private static void swap(int [] array, int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 0, 0, 0, 0, 1, 1, 0 };
		for (int i : sort(a)) {
			System.out.println(i);
		}
	}
}
