
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

	private void subSet(int exp, int sum, String s) {
		// System.out.print( " exp " + exp + " val "+ val + "\n");

		if (sum == N) {
			System.out.print(s + "\n");
			return;
		} else {

			for (int i = exp; i < arr.length; i++) {
				if (arr[i] < sum || sum < N) {
					subSet(exp +1, sum + arr[i], s + String.valueOf(arr[i]) );
				}
			}
		}
	}

	public static void main(String arg[]) {
		RecursionFindSumSubset rsum = new RecursionFindSumSubset();

		rsum.subSet();

	}
}
