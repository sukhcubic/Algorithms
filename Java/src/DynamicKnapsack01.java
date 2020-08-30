class DynamicKnapsack01{
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

    //Explanation: https://www.youtube.com/watch?v=kvyShbFVaY8\
        // 0/1 Knapsack

//     private static int knapsackHelper(int target, int[] wt, int[] val, int len){
//         //Base case
//         if(len == 0 || target == 0 ){
//             return  0;
//         }


//         // weight is higher we are not including. recurse remaining elements
//         if(wt[len-1] > target){
//             return  knapsackHelper(target, wt,val, len-1);
//         }else{
//             // we have choice to include or not include and get max value
//             return Math.max(val[len-1] +knapsackHelper(target- wt[len-1],wt, val, len-1),  knapsackHelper(target, wt, val, len-1));
//         }
//     }
    
    static Map<String ,Integer> set = new HashMap<>();
    private static int knapsackHelper(int target, int[] wt, int[] val, int len){

        //Base case
        if(len == 0 || target == 0 ){
            return  0;
        }
        String key = target + "|" + len;


        if(set.containsKey(key)){
            return set.get(key);
        }
        // weight is higher we are not including. recurse remaining elements
        if(wt[len-1] > target){
            int x = knapsackHelper(target, wt,val, len-1);

            set.put(key, x);
            return  x;
        }else{
            // we have choice to include or not include and get max value
            int x =  Math.max(val[len-1] +knapsackHelper(target- wt[len-1],wt, val, len-1),  knapsackHelper(target, wt, val, len-1));

            set.put(key, x);

            return x;

            //            int temp1 = val[len-1] +knapsackHelper(target- wt[len-1],wt, val, len-1);
//            int temp2 = knapsackHelper(target, wt, val, len-1);
//            if(temp1>temp2){
//                return temp1;
//            }else {
//                return temp2;
//            }
//           // return (temp1>temp2)  ? temp1 :temp1;
        }
    }

    //https://www.youtube.com/watch?v=ntCGbPMeqgg
    //Top Down knapsack
    //https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/Knapsack01.java
    //https://medium.com/@fabianterh/how-to-solve-the-knapsack-problem-with-dynamic-programming-eb88c706d3cf
       // 0/1 Knapsack  Top Down


    private static int knapSackTopDown(int[] wt, int[] val, int W){
        int[][] K = new int[val.length+1][W+1];

//https://www.youtube.com/watch?v=nLmhmB6NzcM&t=828s
        for (int i= 0; i <= val.length; i++ ){
            for(int j= 0; j <= W; j++){
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                    continue;
                }
                if(j-wt[i-1] >= 0){
                    K[i][j] =Math.max(val[i-1]+K[i-1][j-wt[i-1]], K[i-1][j] );
                }else{
                    K[i][j] = K[i-1][j];
                }
            }
        }
        printVal(K);
        return K[val.length][W];
    }

    public static  int bottomUpDP(int val[], int wt[], int W){
        int K[][] = new int[val.length+1][W+1];
        for(int i=0; i <= val.length; i++){
            for(int j=0; j <= W; j++){
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                    continue;
                }
                if(j - wt[i-1] >= 0){
                    //https://www.youtube.com/watch?v=nLmhmB6NzcM&t=609s
                    K[i][j] = Math.max(val[i-1]+K[i-1][j-wt[i-1]], K[i-1][j] );
                }else{
                    //fill previous object while j < wt or until j(bag capacity is reached to hold wt[i-1])
                    //https://www.youtube.com/watch?v=nLmhmB6NzcM&t=938s
                    K[i][j] = K[i-1][j];
                }
            }
        }
        return K[val.length][W];
    }

    static void  printVal(int[][] val){
        for (int i= 0; i < val.length; i++ ){
            String s= "";
            for(int j= 0; j < val[0].length; j++){
                s+=String.valueOf(val[i][j])+" ";
            }
            System.out.println(s);
        }
    }

    private static int knapSackUnbounded(){
       return 0;
    }

    public static void main(String[] args){
        int wt[] =  { 10, 20,  30,  30};
        int val[] = { 6, 10, 12, 9};

        int W = 20;
        int n = val.length;
 //       System.out.println(knapSack(W, wt, val, n ));
//        for (Map.Entry<String, Integer> in:set.entrySet()
//             ) {
//            System.out.println(in.getValue());
//
//        }

        System.out.println(knapSackTopDown(wt, val, W));

        System.out.println(bottomUpDP(val, wt, W));

    }
}
