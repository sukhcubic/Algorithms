public class DynamicSubsetSum {
    //https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7

    //ToDo
    static boolean subset(int[] val, int sum){
        boolean[][] K = new boolean[val.length + 1][sum + 1];
            for(int i=1; i <= val.length; i++){
                for(int j=1; j <= sum; j++){
                    if(i == 0){
                        K[i][j] = false;
                    }
                    if(j == 0){
                        K[i][j] = true;
                    }
                    if(val[i-1] > j){
                        K[i][j] = K[i-1][j];
                    }else{
                        K[i][j] =  K[i-1][j-val[i-1]] || K[i-1][j];
                    }
                }
            }
        return K[val.length][sum];
    }

    //TODO: Implement memoization
    // this is based on binary tree
    static boolean subset(int[] val, int sum, int index){

        if(sum == 0){
          return true;
        }

        if(index < 0 || sum < 0 ){
           return false;
        }
        boolean incuded = subset(val, sum-val[index], index-1);

        boolean excluded = subset(val, sum, index-1);

        return incuded || excluded;

    }


    public static void main(String args[]){
        int items[] = { 1, 2, 5, 6, 7, 8, 10};
        int sum = 150;

        System.out.println(subset(items, sum, 6));
    }
}
