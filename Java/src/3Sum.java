
public class ThreeSum {

	private static String sumOfThreeNumbers(int[] list, int desired) {
		// For array which is already sorted
		int x = 0;
		int y = 0;

		for (int i = 0; i < list.length - 2; i++) {
			x = i + 1;
			y = list.length - 1;
			System.out.println(x + "x");
			while (x < y) {
				System.out.println(y + "y");
				if (i + list[x] + list[y] == desired) {
					return "found ";
				} else if (i + list[x] + list[y] < desired) {
					x++;
				} else {
					y--;
				}
			}
		}

		return "Not Found";
	}
	
	private static void  sumOfThreeNumbers1(int[] list, int desired) {

		//Sort if not already sorted. Sorted array decrease overall runtime o(n)2 
		Arrays.sort(list);
		int x = 0;
		int y = 0;
		for(int a= 0; a<list.length-2; a++) {
			x = a+1;
			y= list.length-1;
			while(x < y) {
				
				if(list[a]+list[x]+list[y] == desired) {
					System.out.print("   match "+  list[a] + " "+ list[x] + " "+ list[y] +" "+ "\n");
					x++;
					y--;
					// if sum is less than desired then increase left by one because array is sorted and left>right is ascending order and will pick small element.
					//otherwise decrease right which is higher number.
				} else if (list[a] + list[x] + list[y] < desired) {
					x++;
				} else {
					y--;
				}
			}
		}

	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 2, 4, 5, 6, 7, 8, 9 };
		int desiredSum = 20;
		System.out.println(sumOfThreeNumbers(a, desiredSum));
	}

}
