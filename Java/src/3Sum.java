
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

		private static void sumOfThreeNumbers2(int[] list, int desired) {
		// There are no duplicates
	        // one way of doing

		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Integer ints : list ) {
			map.put(ints, "");
		}
                 int last = list.length-1;
		for(int a= 0; a<list.length; a++) {
			if(a<last) {
				int x = list[a];
				int y = list[last--];
				if(x+y > desired) {
					continue;
				}else {
					int z =desired - (x+y);
					map.remove(x);
					map.remove(y);

					if(map.containsKey(z)) {
						System.out.print( "found " + x+ " " + y +" "+ z+ "\n ");
					}
					map.put(x, "");
					map.put(y, "");
				}
			}else {
				break;
			}
			
		}

	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 2, 4, 5, 6, 7, 8, 9 };
		int desiredSum = 20;
		System.out.println(sumOfThreeNumbers(a, desiredSum));
	}

}
