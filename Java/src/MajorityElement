import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
//	 Given an array with nn keys, design an algorithm to find all values that occur more than n/k times.
//	 The expected running time of your algorithm should be linear

	public static Integer find(int[] list) {
		int value = -1;
//		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//		for (int i : list) {
//			if(map.containsKey(i) &&  map.get(i) > list.length/10 ) {
//				return i;
//			}else {
//				map.put(i, map.getOrDefault(i, 0) +1);
//			}
//		}
		
		 Integer num = null;
		int count = 0;
		for (int i : list) {
			if(count == 0) {
				num = i;
				count=1;
				continue;
			}else {
				if(num == i) {
					count++;
				}else {
					count--;
				}
			}
		}
		count = 0;
		for(int i : list) {
			if(i == num) {
				count++;
			}
		}
		System.out.println(count);
		return num;
		
//		 from leetcode
		
//		  int count = 0;
//	        Integer candidate = null;
//
//	        for (int num : list) {
//	            if (count == 0) {
//	                candidate = num;
//	            }
//	            count += (num == candidate) ? 1 : -1;
//	        }
//
//	        return candidate;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {3, 3, 2,2,4,4,4,3,3 };
		System.out.println(find(a));
	
	}
}
