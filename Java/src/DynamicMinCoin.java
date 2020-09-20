import java.util.Arrays;

public class DynamicMinCoin {
    //https://leetcode.com/problems/coin-change
    //Explanation:   https://www.youtube.com/watch?v=jgiZlGzXMBw

    static int countx = Integer.MAX_VALUE;

    private static int min(int[] items, int sum) {
        if(sum < 0){
            countx = -1;
        }
         min(items, sum, 0, 0);
         return countx;
    }
//  O(2^n)
    static void min(int[] items, int sum, int index, int count){
        if (sum == 0){
            countx = Math.min(countx, count);
        }
        if(index < items.length && sum>=0) {
            min(items, sum - items[index], index, count +1);// including same coin over
            min(items, sum, index + 1, count );// not including
        }
    }

    //Dynamic programming
//    https://www.youtube.com/watch?v=jgiZlGzXMBw
    static int minCoin(int[] coins, int sum){
        int max = sum + 1;
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i<=sum; i++) {
            for (int j = 0; j<coins.length; j++) {
                if(coins[j] <= i ){
                  //  https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16 at 25:15

                    dp[i] =Math.min(dp[i], dp[i-coins[j]]+1);// we are adding one because we are taking that coin so coin count goes up by one.
                }
            }
        }
        return dp[sum];
    }
    public static void main(String args[]){
        int items[] = { 1, 5, 10};
        int sum = 10;

        //System.out.println(min(items, sum));
        System.out.println(minCoin(items, sum));
    }
}
