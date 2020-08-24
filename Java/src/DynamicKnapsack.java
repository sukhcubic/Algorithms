class DynamicKnapsack{
    //Types of Knapsack: https://www.youtube.com/watch?v=l02UxPYRmCQ
    //1. 0/1 full item
    //2. Fraction
    //3. Unbounded  same item can be added multiple times
    //DP: https://atcoder.jp/contests/dp/tasks


    public static void main(String[] args){
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n ));
    }

    private static int knapSack(int target, int[] wt, int[] val, int len) {
        int i = knapsackHelper(target, wt, val, len);
        return  i;
    }

    //Explanation: https://www.youtube.com/watch?v=kvyShbFVaY8
    private static int knapsackHelper(int target, int[] wt, int[] val, int len){
        //Base case
        if(len == 0 || target == 0 ){
            return  0;
        }


        // weight is higher we are not including. recurse remaining elements
        if(wt[len-1] > target){
            return  knapsackHelper(target, wt,val, len-1);
        }else{
            // we have choice to include or not include and get max value
            return Math.max(val[len-1] +knapsackHelper(target- wt[len-1],wt, val, len-1),  knapsackHelper(target, wt, val, len-1));
        }
    }
}
