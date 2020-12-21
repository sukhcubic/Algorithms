import java.util.Arrays;

public class DynamicHouseRobberiiREVISIT {
        public int rob(int[] nums) {
            // since houses are in circle so we are taking first element and skipping last
            // and in second call we are taking last skipping first and take max of both


            if(nums.length ==0){
                return 0;
            }


            if(nums.length == 1){
                return nums[0];
            }
            return Math.max(robber(Arrays.copyOfRange(nums, 0, nums.length-1)),
                    robber(Arrays.copyOfRange(nums, 1, nums.length)));
        }

        private int robber(int[] nums){
            //if size is 0 return 0
            if(nums.length ==0){
                return 0;
            }

            //if size is 1 return value
            if(nums.length == 1){
                return nums[0];
            }

            //if size is 2 return max value of both
            if(nums.length == 2){
                return Math.max(nums[0], nums[1]);
            }

            int[] dp = new int[nums.length];
            //intilize array
            dp[0] = nums[0];
            dp[1] = nums[0]>nums[1] ?nums[0]:nums[1];

            for(int i = 2; i< nums.length; i++){
                // similar to knap sack take current or not of take current then add n-2      becasuse we cannot add adjacent. If not taking current take previous and get max value.

                dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
            }

            return dp[nums.length-1];
        }
}
