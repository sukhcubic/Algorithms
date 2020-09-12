public class DynamicCountSubset {
    //https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9
    //Problem: https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x-using-recursion/
    //Count total number of subset that gives total sum eg. given sum is 10 how many subset in given array makes sum of 10.
   
    private static int countSubsetSum(int[] val, int sum) {
        //int result = 0;
        int[][] K = new int[val.length+1][sum+1];
       // return countSubsetSum(val, sum, val.length-1);
        //memoized
        return countSubsetSum(val, sum, val.length-1, K);

    }

    
    //Inefficient 2^n complexity
    private static int countSubsetSum(int[] val, int sum, int index) {
        if(sum == 0){
            return 1;
        }

        if(index < 0 || sum < 0 ){
            return 0;
        }

       int rightSubtree =  countSubsetSum(val, sum - val[index], index-1);

       int leftSubtree =  countSubsetSum(val, sum, index-1);


       //Why we are adding this? because each sub tree (binary tree) might have sum available
       return rightSubtree+leftSubtree;
    }

    //DP Memoized n*m time complexity 
      private static int countSubsetSum(int[] val, int sum, int index, int[][] K) {
        if(sum == 0){
            return 1;
        }

        if(index < 0 || sum < 0 ){
            return 0;
        }

        if(K[index][sum] != 0){
            return K[index][sum];
        }

       int rightSubtree =  countSubsetSum(val, sum - val[index], index-1, K);

       int leftSubtree =  countSubsetSum(val, sum, index-1, K);

       int suma = rightSubtree+leftSubtree;
       K[index][sum] = suma;
       //Why we are adding this? because each sub tree (binary tree) might have sum available
       return suma;
    }



    public static void main(String args[]){
        int items[] = { 1, 2, 5};
        int sum = 1;

        System.out.println(countSubsetSum(items, sum));
    }


}



}
