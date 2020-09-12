public class DynamicCountSubset {
    //https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9
    //Problem: https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x-using-recursion/
    //Count total number of subset that gives total sum eg. given sum is 10 how many subset in given array makes sum of 10.
    private static int countSubsetSum(int[] val, int sum) {
        int result = 0;
        int[][] K = new int[val.length+1][sum+1];





        return 0;
    }


    public static void main(String args[]){
        int items[] = { 1, 2, 5, 6, 7, 8, 10};
        int sum = 150;

        System.out.println(countSubsetSum(items, sum));
    }


}
