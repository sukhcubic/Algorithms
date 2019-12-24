
//Ref: https://algorithms.tutorialhorizon.com/dynamic-programming-subset-sum-problem/
//Ref: https://www.tutorialspoint.com/Subset-Sum-Problem
public class RecursionFindSumSubset {
  //Todo: Fix me

  
	int[] arr = new int[] {1,2,3,5,7,8,9,10};
	int N = 5;
	private void subSet(){
		subSet(arr.length, 0, "");
	}
	
	private void subSet(int exp, int sum, ) {
		//System.out.print( " exp " + exp + " val "+ val + "\n");

		if(exp == 0 || sum == N) {
			System.out.print(val + "\n");
			//return;
		}else {
		
		 for(int i = 0; i < arr.length; i++) {
			subSet(exp -1, sum + arr[i] );
		  }
		}
	}
	
	public static void main(String arg[]) {
		RecursionFindSumSubset rsum = new RecursionFindSumSubset();
		
		rsum.subSet();
	
	}
}
