public class DynamicCoinChangeMax {
//https://leetcode.com/problems/coin-change-2/
//https://leetcode.com/problems/coin-change-2/discuss/847603/Recursive-Top-Down-Bottom-Up-DP-Detailed-Explanation-with-Visualisation

    private static int maxSum(int[] items, int sum) {
        return maxSum(items, sum,0);
    }

    static int maxSum(int[] items, int sum, int index){
        if (sum < 0){
            return 0;
        }
        if (sum == 0){
            return 1;
        }
        if(index==items.length){
           return  0;
        }
       int x = maxSum(items, sum-items[index],  index);// including same coin over
        int y = maxSum(items, sum , index+1);// including next coin
        return x+y;
    }

    public static void main(String args[]){
        int items[] = { 1, 5, 10};
        int sum = 1000;

        System.out.println(maxSum(items, sum));
    }
}
