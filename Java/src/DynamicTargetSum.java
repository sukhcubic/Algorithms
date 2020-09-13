public class DynamicTargetSum {
    //https://leetcode.com/problems/target-sum/
   // https://medium.com/swlh/solving-the-target-sum-problem-with-dynamic-programming-and-more-b76bd2a661f9

    private static int targerSum(int[] items, int sum) {
       // return targerSumHelper(items, sum, items.length-1);
       

        
        // Best mathematical explanation
        // This is based on Math equation defined in DynamicSubsetDifferenceCount.java
//         int s = 0;
//         for (int x:items
//              ) {
//             s+=x;
//         }
//         s = (s+sum)/2;
//         return targerSumHelper(items, s, items.length-1);
        
                //another way not efficient
        return targerSumHelper(items, 0, 0, sum);
    }

//    private static int targerSumHelper(int[] items, int sum, int index) {
//        if(index<0 || sum<0){
//            return 0;
//        }
//        if(sum == 0){
//            return 1;
//        }
//        int rightSubtree =  targerSumHelper(items, sum + items[index], index-1);
//
//        int leftSubtree =  targerSumHelper(items, sum-items[index], index-1);
//
//        return rightSubtree+leftSubtree;
//    }

    private static int targerSumHelper(int[] items, int sum, int index) {

        if(sum == 0){
            return 1;
        }
        if(index<0 || sum<0){
            return 0;
        }
        int rightSubtree =  targerSumHelper(items, sum - items[index], index-1);

        int leftSubtree =  targerSumHelper(items, sum, index-1);

        return rightSubtree+leftSubtree;
    }

    static int count = 0;
    public static int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }
    public static void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }

        
    private static int targerSumHelper(int[] items, int index, int sum, int SUM) {
        if(index == items.length){
            return sum == SUM ? 1:0;
        }
        return targerSumHelper(items, index+1, sum-items[index], SUM) + targerSumHelper(items, index+1,sum + items[index], SUM);
    }

    public static void main(String args[]){
        int items[] = { 1, 1, 1, 1, 1};
        int sum = 3;

        //Output should be 5
        //Explanation from LeetCode
//        Input: nums is [1, 1, 1, 1, 1], S is 3.
//        Output: 5
//        Explanation:
//        -1+1+1+1+1 = 3;
//        +1-1+1+1+1 = 3;
//        +1+1-1+1+1 = 3;
//        +1+1+1-1+1 = 3;
//        +1+1+1+1-1 = 3;
//        There are 5 ways to assign symbols to make the sum of nums be target 3.

        System.out.println(targerSum(items, sum));
        //System.out.println(findTargetSumWays(items, sum));
    }
}
