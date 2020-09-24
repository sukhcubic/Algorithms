class DynamicMaxSubarraySum{
// Explanation: https://www.youtube.com/watch?v=Id_hZTV7_IA
    private static int maxSum(int[] items) {
        int globalSum = 0;
        int runningSum = 0;
        for(int i = 0; i<items.length; i++){
            //Take running sum(sum for previous items) + curr item
            runningSum = Math.max(runningSum+items[i], items[i]);
            //then take max of running and global
            globalSum = Math.max(globalSum, runningSum);
        }
        return globalSum;
    }

    public static void main(String args[]){
        //nt items[] = { 1, 5, 10};
         int items[] = { 1, -5, 0};
        System.out.println(maxSum(items));
    }
}
