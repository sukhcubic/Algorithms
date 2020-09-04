class DynamicPartitionEqualSum{
  
      //Problem: https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3jEPRo5PDvx

    public static boolean canPartition(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++)
            sum += num[i];

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if(sum % 2 != 0)
            return false;

        return canPartitionRecursive(num, sum/2, 0);
    }
//Brute force
 private static  boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {
        // base check
        if (sum == 0)
            return true;

        if (num.length == 0 || currentIndex >= num.length)
            return false;

        //include

        if(sum-num[currentIndex] >= 0){
            if(canPartitionRecursive(num, sum-num[currentIndex], currentIndex+1)) {
                return true;
            }
        }

        // exclude
       return canPartitionRecursive(num, sum, currentIndex+1);

    }
  
  //Dynamic programmin Solution

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(canPartition(num));
    }

}
