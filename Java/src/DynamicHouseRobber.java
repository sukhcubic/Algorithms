
public class DynamicHouseRobber {
  //  https://leetcode.com/problems/house-robber/
//https://www.youtube.com/watch?v=73r3KWiEvyk
    static int rob(int[] items){
        if(items.length == 2){
           return items[0]>items[1] ?items[0]:items[1];
        }

        int [] dp = new int[items.length];
        dp[0] = items[0];
        dp[1] = items[0]>items[1] ?items[0]:items[1];
        for(int i = 2; i<items.length; i++) {
            dp[i] = Math.max(dp[i-1], items[i]+dp[i-2]);
        }
        return dp[items.length-1];
    }
  
 
    // This is quite close to rod cutting problem. Take current and get remaining from item-2. Slit into small sub problems.
    static int rob1(int[] items){
        int rob1 = 0;
        int rob2 = 0;
        int temp = 0;

        for(int i = 0; i<items.length; i++) {
            temp = Math.max(rob1, items[i]+rob2);
            rob2 = rob1;
            rob1 = temp;
        }
        return temp;
    }
  
    public static void main(String args[]){
        int items[] = { 2,1,1,2};
        //out 12
        System.out.println(rob(items));
    }
}
