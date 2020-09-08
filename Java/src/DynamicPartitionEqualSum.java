class DynamicPartitionEqualSum{
  
      //Problem: https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3jEPRo5PDvx

    public static boolean canPartition(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++)
            sum += num[i];

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if(sum % 2 != 0)
            return false;

        return canPartitionRecursive(num, sum/2, 0);
    }
//Brute force
 private static  boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {
        // base check
        if (sum == 0)
            return true;

        if (num.length == 0 || currentIndex >= num.length)
            return false;

        //include

        if(sum-num[currentIndex] >= 0){
            if(canPartitionRecursive(num, sum-num[currentIndex], currentIndex+1)) {
                return true;
            }
        }

        // exclude
       return canPartitionRecursive(num, sum, currentIndex+1);

    }
  
  //Dynamic programming Solution
  public class DynamicEqualSubsetSum {
    //Problem: https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3jEPRo5PDvx

    public static boolean canPartition(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++)
            sum += num[i];

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if(sum % 2 != 0)
            return false;

        boolean[][] value = new boolean[num.length][sum/2+1];
        return canPartitionRecursive(num, value, sum/2, 0);
    }

    private static  boolean canPartitionRecursive(int[] num, boolean[][] arr, int sum, int currentIndex) {
        // base check
        if (sum == 0)
            return true;

        if (num.length == 0 || currentIndex >= num.length)
            return false;

        //include

        if(sum-num[currentIndex] >= 0){
            if(canPartitionRecursive(num, arr, sum-num[currentIndex], currentIndex+1)) {

                arr[currentIndex][sum] = true;
                return true;
            }
        }

        // exclude
        arr[currentIndex][sum] = canPartitionRecursive(num, arr, sum, currentIndex+1);
        return  arr[currentIndex][sum];
    }
//Bottom up iterative approach
     private static  boolean canPartitionIterative(int[] num) {
        List<Integer> ar = new ArrayList<>();
        int n = num.length;
        // find the total sum
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += num[i];

        // if 'sum' is a an odd number, we can't have two subsets with same total
        if(sum % 2 != 0)
            return false;

        // we are trying to find a subset of given numbers that has a total sum of ‘sum/2’.
        sum /= 2;

        boolean[][] dp = new boolean[n][sum + 1];

        // populate the sum=0 column, as we can always have '0' sum without including any element
        for(int i=0; i < n; i++)
            dp[i][0] = true;

        // with only one number, we can form a subset only when the required sum is equal to its value
        for(int s=1; s <= sum ; s++) {
            dp[0][s] = (num[0] == s ? true : false);
        }

        // process all subsets for all sums
        for(int i=1; i < n; i++) {
            for(int s=1; s <= sum; s++) {
                // if we can get the sum 's' without the number at index 'i'
                if(dp[i-1][s]) {
                    dp[i][s] = dp[i-1][s];
                } else if (s >= num[i]) { // else if we can find a subset to get the remaining sum
                    dp[i][s] = dp[i-1][s-num[i]];
                }
            }
        }
        // the bottom-right corner will have our answer.
        return dp[n-1][sum];
    }

    
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 4};
        System.out.println(canPartition(num));
    }
}


    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(canPartition(num));
    }

}
