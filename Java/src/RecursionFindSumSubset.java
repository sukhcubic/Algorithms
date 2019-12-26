
//Ref: https://algorithms.tutorialhorizon.com/dynamic-programming-subset-sum-problem/
//Ref: https://www.tutorialspoint.com/Subset-Sum-Problem
//https://medium.com/@sourabreddy
//https://medium.com/leetcode-patterns/leetcode-pattern-3-backtracking-5d9e5a03dc26
//https://iq.opengenus.org/subset-sum-problem-backtracking/

public class RecursionFindSumSubset {
  //Todo: Fix me
	int[] arr = new int[] { 1, 2, 3, 5, 7, 8, 9, 10 };
	int N = 5;

	private void subSet() {
		subSet(0, 0, "");
	}

	private void subSet(int start, int sum, String s) {
		if (sum == N) {
			System.out.print(s + "\n");
			return;
		} else {
		  for (int i = start; i < arr.length; i++) {
			subSet(i +1, sum + arr[i], s + String.valueOf(arr[i]) );
		  }
	       }
	}


	public static void main(String arg[]) {
		RecursionFindSumSubset rsum = new RecursionFindSumSubset();

		rsum.subSet();

	}
}
