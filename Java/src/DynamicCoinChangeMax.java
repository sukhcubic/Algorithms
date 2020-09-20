public class DynamicCoinChangeMax {
//https://leetcode.com/problems/coin-change-2/
//https://leetcode.com/problems/coin-change-2/discuss/847603/Recursive-Top-Down-Bottom-Up-DP-Detailed-Explanation-with-Visualisation
    private static int maxSum(int[] items, int sum) {
        return maxSum(items, sum,0);
    }

    static int maxSum(int[] items, int sum, int index){
        if (sum < 0){
            return 0;
        }
        if (sum == 0){
            return 1;
        }
        if(index==items.length){
           return  0;
        }
       int x = maxSum(items, sum-items[index],  index);// including same coin over
        int y = maxSum(items, sum , index+1);// including next coin
        return Math.min(x, y);
    }

    static Map<String, Integer> map = new HashMap<>();
    //https://www.youtube.com/watch?v=K9Css2vzFSo&list=PLamEquLLzOthagi6UdX3mFmCY3oWy79iV
    static int maxSum1(int[] items, int sum, int index){
        if (sum < 0){
            return 0;
        }
        if (sum == 0){
            return 1;
        }
        if(index==items.length){
            return  0;
        }
        String key = index + " " + sum;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int x = maxSum1(items, sum-items[index],  index);// including same coin over
        int y = maxSum1(items, sum , index+1);// including next coin

        map.put(key,x+y );

        return map.get(key);

    }

    public static void main(String args[]){
        int items[] = { 1, 5, 10};
        int sum = 100;

        System.out.println(maxSum1(items, sum, 0));
    }
}
