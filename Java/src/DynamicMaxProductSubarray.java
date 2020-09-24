public class DynamicMaxProductSubarray {
    //https://leetcode.com/problems/maximum-product-subarray/
    //https://www.youtube.com/watch?v=1s0r7Ixir80
    //https://www.youtube.com/watch?v=hJ_Uy2DzE08&t=308s
    static  int maxProduct(int[] nums){
        if (nums.length == 0) return 0;
        int runningMin = nums[0];
        int runningMax = nums[0];
        int result = runningMax;

        for(int i = 1; i < nums.length; i++){
            //Select max number> Also assign max to temp value because we are mutiplying and getting results
            // from previous num to so far.
            int temp_max  = Math.max(Math.max(runningMax*nums[i], runningMin*nums[i]), nums[i]);

            //We are just keeping track of Min value so that if -ve appears in next iteration we can find max by
            // multiplying -ve with another -ve
            runningMin = Math.min(Math.min(runningMax*nums[i], runningMin*nums[i]), nums[i]);

            runningMax = temp_max;
            // runningMin can be greater if we multiply two -ve numbers
            result = Math.max(runningMax, result);
        }

        return result;
    }

  // Another variant to find Min product
    static  int minProduct(int[] nums){
        if (nums.length == 0) return 0;
        int runningMin = nums[0];
        int runningMax = nums[0];
        int result = runningMax;

        for(int i = 1; i < nums.length; i++){
            //Select max number> Also assign max to temp value because
            int temp_max  = Math.max(Math.max(runningMax*nums[i], runningMin*nums[i]), nums[i]);

            //select min number
            runningMin = Math.min(Math.min(runningMax*nums[i], runningMin*nums[i]), nums[i]);

            runningMax = temp_max;
            // runningMin can be greater if we multiply two -ve numbers
//            result = Math.max(runningMax, result);
            result = Math.min(runningMin, result);
        }

        return result;
    }

    public static void main(String args[]){
        //int items[] = { 1, 5, 10};
        int items[] = {-2,3,-4};
        //int items[] = {2,3,-2,4};
       //  int items[] = { 1, -5, 0};
        System.out.println(maxProduct(items));
    }
}
