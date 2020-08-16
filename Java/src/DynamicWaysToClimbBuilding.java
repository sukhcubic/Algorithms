//Explanation: https://www.youtube.com/watch?v=sF7hzgUW5uY&t=5s
public class DynamicWaysToClimbBuilding {


    //Mamoization and recursion
    Map<Integer, Integer> hash = new HashMap<>();
    int ways(int totalSteps){
         if(totalSteps<= 1){
             return 1;
         }
         if(hash.containsKey(totalSteps)){
             return hash.get(totalSteps);
         }
         int  value = ways(totalSteps-1)+ ways(totalSteps-2);
         hash.put(totalSteps, value);
        return value;
    }

    //Dynamic top bottom up

    int numWays(int totalSteps){

        if(totalSteps<= 1){
            return 1;
        }
        int[] dp = new int[totalSteps+ 1];
        //filled array with values
        dp[1] = 1; // one step for one stair
        dp[2] = 2; // two ways to reach 2 steps either 1-1 or 2 steps
        for (int i = 3; i <= totalSteps; i++) {
            dp[i] += dp[i-1] + dp[i-2];
        }

        return dp[totalSteps];
    }

    public static void main(String args[]){
        DynamicWaysToClimbBuilding steps = new DynamicWaysToClimbBuilding();
        long t1= System.currentTimeMillis();
        System.out.println(steps.numWays(1000000));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
