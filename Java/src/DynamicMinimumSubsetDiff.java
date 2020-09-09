public class DynamicMinimumSubsetDiff {
//Find min difference between subsets

    private static int minSum(int[] num) {
   int sum = 0;

        for (int i :num) {
           sum+= i;
        }

        if(sum == 0){
            return 0;
        }
        sum = sum/2;

        boolean[][] K = new boolean[num.length+1][sum+1];

        for (int i = 0; i <= num.length; i++)
            K[i][0] = true;

        // Initialize top row, except dp[0][0],
        // as false. With 0 elements, no other
        // sum except 0 is possible
        for (int i = 1; i <= sum; i++)
            K[0][i] = false;

        for (int i = 1; i < num.length; i++){
            for (int j =1; j< sum ; j++){

                if(num[i]> sum){
                    //Previous value
                    K[i][j]  = K[i-1][j];
                }else{
                    K[i][j]  = K[i-1][j] ||  K[i-1][j-num[i-1]];
                }
            }
        }

        
        //TODO:
        // Initialize difference of two sums.
        int diff = Integer.MAX_VALUE;

        // Find the largest j such that dp[n][j]
        // is true where j loops from sum/2 t0 0
        for (int j = sum / 2; j >= 0; j--)
        {
            // Find the
            if (K[num.length][j] == true)
            {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }
    
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 10};
        System.out.println(minSum(num));
    }
    
}
