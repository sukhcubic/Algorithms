
import java.util.HashMap;
import java.util.Map;

public class DynamicIntegerBreak {
  //https://leetcode.com/problems/integer-break/
    //Exp: https://leetcode.com/problems/integer-break/discuss/843882/Java-Similar-to-Unbounded-Knapsack-(Brute-Force-Recursion-With-Memoization-2D-Dynamic-Programming)
    //Hint: Unbounded knapack

//    Given a positive integer n, break it into the sum of at least two positive
//    integers and maximize the product of those integers. Return the maximum product you can get.
//    Example 1:
//    Input: 2
//    Output: 1
//    Explanation: 2 = 1 + 1, 1 × 1 = 1.

//    Example 2:
//    Input: 10
//    Output: 36
//    Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

    static Map<Integer, Integer> cache = new HashMap<>();

    static int maxProduct(int len){
        return maxProductHelper(len, len-1);
    //No sure how this works. Come back later
    static int maxProductHelper(int n, int sum) {
//        // if length less than 0
//        if (len < 0 || sum < 0) {
//            return 0;
//        }
//
//        if(len == 0)
//            return 1;
//        if(sum == 0)
//            return 0;
//
//        if (len < sum) {
//           return maxProductHelper(len, sum-1);
//        } else {
//            return Math.max(maxProductHelper(len, sum-1), sum * maxProductHelper(len-sum, sum));
//        }

        if(n <= 2) return 1;
        if(n == 3) return 2;

        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++){            // Cost of breaking integer into parts
            for(int j = i; j <= n; j++){        // breaking integer, starts from 1 to n
                dp[j] = Math.max(dp[j], i * dp[j-i]);
            }
        }
        return dp[n];
    }


    public static void main(String args[]){
        int num = 5;
        System.out.println(maxProduct(num));
    }


}

